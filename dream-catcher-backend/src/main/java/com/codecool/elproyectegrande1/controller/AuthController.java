package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.entity.*;
import com.codecool.elproyectegrande1.jwt.JwtUtils;
import com.codecool.elproyectegrande1.payload.request.LoginRequest;
import com.codecool.elproyectegrande1.payload.request.SignupRequest;
import com.codecool.elproyectegrande1.payload.response.JwtResponse;
import com.codecool.elproyectegrande1.payload.response.MessageResponse;
import com.codecool.elproyectegrande1.repository.MentorRepository;
import com.codecool.elproyectegrande1.repository.RoleRepository;
import com.codecool.elproyectegrande1.repository.UserRepository;
import com.codecool.elproyectegrande1.service.DreamerService;
import com.codecool.elproyectegrande1.service.MentorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

    private final DreamerService dreamerService;
    private final MentorService mentorService;

    private final String DREAMER = "dreamer";
    private final String MENTOR = "mentor";
    private final String ADMIN = "admin";
    private final MentorRepository mentorRepository;

    @Autowired
    public AuthController(DreamerService dreamerService, MentorService mentorService,
                          MentorRepository mentorRepository) {
        this.dreamerService = dreamerService;
        this.mentorService = mentorService;
        this.mentorRepository = mentorRepository;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest, HttpSession session) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);
        User user = userRepository.findByUsername(loginRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        if(user.getRoles().iterator().next().getName()==ERole.ROLE_MENTOR){
            Mentor mentor = mentorRepository.findByNickname(loginRequest.getUsername()).orElseThrow(() -> new UsernameNotFoundException("User not found"));
            if (!mentor.isVerified()) {
                throw new BadCredentialsException("User not verified!");
            }
        }

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        session.setAttribute("id", userDetails.getId());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles,
                userDetails.getProfilePictureId(),
                userDetails.getImageUrl()));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (userRepository.existsByUsername(signUpRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Username is already taken!"));
        }

        if (userRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already in use!"));
        }

        // Create new user's account
        User user = new User(signUpRequest.getUsername(),
                signUpRequest.getEmail(),
                encoder.encode(signUpRequest.getPassword()));

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_DREAMER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case ADMIN:
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case MENTOR:
                        Role mentorRole = roleRepository.findByName(ERole.ROLE_MENTOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(mentorRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_DREAMER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        for (String entry:strRoles) {
            if (!DREAMER.equals(entry) && !MENTOR.equals(entry) && !ADMIN.equals(entry)) {
                return ResponseEntity.internalServerError().body(new MessageResponse("There's no such role."));
            }
        }

        user.setRoles(roles);
        userRepository.save(user);
        if (strRoles.contains(DREAMER))
            dreamerService.createDreamerFromUser(user);
        if (strRoles.contains(MENTOR))
            mentorService.createMentorFromUser(user);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
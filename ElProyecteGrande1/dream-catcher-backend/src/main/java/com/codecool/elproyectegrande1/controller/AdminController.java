package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.entity.UserDetailsImpl;
import com.codecool.elproyectegrande1.repository.AdminRepository;
import com.codecool.elproyectegrande1.repository.RoleRepository;
import com.codecool.elproyectegrande1.service.AdminService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;
import java.security.Principal;


@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private AdminService adminService;
    private AdminRepository adminRepository;
    private final RoleRepository roleRepository;

    public AdminController(AdminService adminService,
                           RoleRepository roleRepository) { this.adminService = adminService;
        this.roleRepository = roleRepository;
    }

    @PostMapping("/{mentorNickname}/approve")
    public void approveMentor(@PathVariable("mentorNickname") String mentorNickname, Principal principal) throws AccessDeniedException {
        String name = principal.getName();
        System.out.println(name);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        if (authentication != null && authentication.isAuthenticated()) {
//            System.out.println(authentication.getPrincipal());
//            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
//           String user =  userDetails.getUsername();
//        } else {
//            throw new UsernameNotFoundException("User not authenticated");
//        }
        adminService.approveMentor(mentorNickname, "admin");

//        if (adminRepository.existsByNickname(adminName)) {
//            adminService.approveMentor(mentorNickname);
//        } else {
//            return "Dupa";
//        }
//        return "dupa2";
    };
}

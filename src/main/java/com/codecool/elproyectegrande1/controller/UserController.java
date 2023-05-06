package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.user.UserDto;
import com.codecool.elproyectegrande1.entity.Role;
import com.codecool.elproyectegrande1.entity.User;
import com.codecool.elproyectegrande1.entity.UserDetailsImpl;
import com.codecool.elproyectegrande1.security.CurrentUser;
import com.codecool.elproyectegrande1.security.UserPrincipal;
import com.codecool.elproyectegrande1.service.UserService;
import com.codecool.elproyectegrande1.util.CookieUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(value = HttpStatus.OK)
    @PostMapping(value="/upload/avatar", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
        userService.uploadAvatar(file);
    }

    @GetMapping(value ="/avatar/{id}", produces = {MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_JPEG_VALUE})
    @ResponseBody
    public String showAvatar(@PathVariable("id") Long id) {
        byte[] avatar = userService.getAvatarById(id);
        String encodedString = Base64.getEncoder().encodeToString(avatar);
        return encodedString;
    }

    @GetMapping("/profile")
    public UserDto getCurrentUser(@CurrentUser UserPrincipal userPrincipal){
        UserDto user = userService.findUserDtoById(userPrincipal.getId());
        List<String> roles = new ArrayList<>();
        roles.add("ROLE_DREAMER");
        user.setRoles(roles);
        return user;
    }
}

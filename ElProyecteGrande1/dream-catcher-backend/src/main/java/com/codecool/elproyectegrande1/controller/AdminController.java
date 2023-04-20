package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.repository.AdminRepository;
import com.codecool.elproyectegrande1.service.AdminService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/admins")
public class AdminController {

    private AdminService adminService;
    private AdminRepository adminRepository;

    public AdminController(AdminService adminService) { this.adminService = adminService;}

    @PostMapping("/{mentorNickname}/approve")
    public void approveMentor(@PathVariable("mentorNickname") String mentorNickname) {
          adminService.approveMentor(mentorNickname);
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String adminName = authentication.getName();
//        System.out.println(adminName);
//        if (adminRepository.existsByNickname(adminName)) {
//            adminService.approveMentor(mentorNickname);
//        } else {
//            return "Dupa";
//        }
//        return "dupa2";
    };
}

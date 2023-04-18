package com.codecool.elproyectegrande1.controller;

import com.codecool.elproyectegrande1.dto.MentorDto;
import com.codecool.elproyectegrande1.service.AdminService;
import com.codecool.elproyectegrande1.service.MentorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class AdminController {

    private AdminService adminService;

    public AdminController(AdminService adminService) { this.adminService = adminService;}

    //    @GetMapping("/allMentors")
//    public List<MentorDto> getAllMentors() {
//        return mentorService.getAllMentors();
//    }

//    @PostMapping("/admin/{mentorId}/approve")
//    public String approveMentor(@PathVariable("mentorId") Long mentorId) {
//        adminService.approveMentor(mentor);
//        return "redirect:/allMentors";
//    }

}

package com.example.demo.controller;

import com.example.demo.service.AdminService;
import com.example.demo.service.OwnerService;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReportController {

    private final StudentService studentService;
    private final AdminService adminService;
    private final OwnerService ownerService;

    public ReportController(StudentService studentService, AdminService adminService, OwnerService ownerService) {
        this.studentService = studentService;
        this.adminService = adminService;
        this.ownerService = ownerService;
    }

    @GetMapping("/reports")
    public String viewReports(Model model) {
        // Pass all data to the template as JSON strings for the JS
        model.addAttribute("studentsData", studentService.getAll());
        model.addAttribute("adminsData", adminService.getAll());
        model.addAttribute("ownersData", ownerService.getAll());
        return "reports"; // reports.html
    }
}

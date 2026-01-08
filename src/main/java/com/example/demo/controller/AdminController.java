package com.example.demo.controller;

import com.example.demo.model.Admin;
import com.example.demo.service.AdminService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admins")
public class AdminController {

    private final AdminService service;

    public AdminController(AdminService service) {
        this.service = service;
    }

    @GetMapping
    public String listAdmins(Model model) {
        model.addAttribute("admins", service.getAll());
        model.addAttribute("admin", new Admin());
        model.addAttribute("showModal", false);
        return "admins"; // admins.html
    }

    @PostMapping("/save")
    public String saveAdmin(@ModelAttribute Admin admin) {
        service.save(admin);
        return "redirect:/admins";
    }

    @GetMapping("/edit/{id}")
    public String editAdmin(@PathVariable Long id, Model model) {
        Admin a = service.getById(id);
        if (a == null) a = new Admin();
        model.addAttribute("admin", a);
        model.addAttribute("admins", service.getAll());
        model.addAttribute("showModal", true); // 🔥 modal open
        return "admins";
    }

    @GetMapping("/delete/{id}")
    public String deleteAdmin(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/admins";
    }
}

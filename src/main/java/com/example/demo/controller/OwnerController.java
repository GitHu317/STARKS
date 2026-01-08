package com.example.demo.controller;

import com.example.demo.model.Owner;
import com.example.demo.service.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService service;

    public OwnerController(OwnerService service) {
        this.service = service;
    }

    @GetMapping
    public String listOwners(Model model) {
        model.addAttribute("owners", service.getAll());
        model.addAttribute("owner", new Owner());
        model.addAttribute("showModal", false);
        return "owners";
    }

    @PostMapping("/save")
    public String saveOwner(@ModelAttribute Owner owner) {
        service.save(owner);
        return "redirect:/owners";
    }

    @GetMapping("/edit/{id}")
    public String editOwner(@PathVariable Long id, Model model) {
        Owner o = service.getById(id);
        if (o == null) {
            o = new Owner();
        }
        model.addAttribute("owner", o);
        model.addAttribute("owners", service.getAll());
        model.addAttribute("showModal", true); // 🔥 open modal
        return "owners";
    }

    @GetMapping("/delete/{id}")
    public String deleteOwner(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/owners";
    }
}

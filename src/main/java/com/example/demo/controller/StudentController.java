package com.example.demo.controller;

import com.example.demo.model.Student;
import com.example.demo.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/students")
public class StudentController {

    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @GetMapping
    public String listStudents(Model model) {
        model.addAttribute("students", service.getAll());
        model.addAttribute("student", new Student());
        model.addAttribute("showModal", false);
        return "students"; // students.html
    }

    @PostMapping("/save")
    public String saveStudent(@ModelAttribute Student student) {
        service.save(student);
        return "redirect:/students";
    }

    @GetMapping("/edit/{id}")
    public String editStudent(@PathVariable Long id, Model model) {
        Student s = service.getById(id);
        if (s == null) {
            // fallback to new student if id not found
            s = new Student();
        }
        model.addAttribute("student", s);
        model.addAttribute("students", service.getAll());
        model.addAttribute("showModal", true); // tell the view to open modal
        return "students";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        service.delete(id);
        return "redirect:/students";
    }
}

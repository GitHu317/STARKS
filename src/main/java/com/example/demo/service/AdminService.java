package com.example.demo.service;

import com.example.demo.model.Admin;
import com.example.demo.repository.AdminRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AdminService {

    private final AdminRepository repo;

    public AdminService(AdminRepository repo) {
        this.repo = repo;
    }

    public List<Admin> getAll() {
        return repo.findAll();
    }

    public Admin save(Admin admin) {
        return repo.save(admin);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Admin getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}

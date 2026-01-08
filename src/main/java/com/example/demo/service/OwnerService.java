package com.example.demo.service;

import com.example.demo.model.Owner;
import com.example.demo.repository.OwnerRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OwnerService {

    private final OwnerRepository repo;

    public OwnerService(OwnerRepository repo) {
        this.repo = repo;
    }

    public List<Owner> getAll() {
        return repo.findAll();
    }

    public Owner save(Owner owner) {
        return repo.save(owner);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

    public Owner getById(Long id) {
        return repo.findById(id).orElse(null);
    }
}

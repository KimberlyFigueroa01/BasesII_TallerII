package com.taller2.taller2.controllers;

import com.taller2.taller2.models.Editorial;
import com.taller2.taller2.models.Libro;
import com.taller2.taller2.repository.EditorialRepository;
import com.taller2.taller2.services.EditorialServices;

import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/editorials")
public class EditorialController {

    @Autowired
    private final EditorialServices editorialServices;
    @Autowired
    private EditorialRepository editorialRepository;

    @Autowired
    public EditorialController(EditorialServices editorialServices) {
        this.editorialServices = editorialServices;
    }

    @GetMapping
    public List<Editorial> getAllEditorials() {
        return editorialRepository.findAll();
    }

    @GetMapping("/findAll")
    public List<Editorial> findAll() {
        return editorialRepository.findAll();
    }

    @PutMapping("path/{id}")
    public Editorial putMethodName(@PathVariable Long id, @RequestBody Editorial entity) {
        // TODO: process PUT request

        return this.editorialRepository.save(entity);
    }

    @PostMapping("/save")
    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request

        return entity;
    }

    @GetMapping("Editorial/{id}")
    public List<Libro> getEditorialById(@PathVariable Long id) {
        return this.editorialServices.getEditorialById(id);
    }

}

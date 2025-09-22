package com.taller2.taller2.controllers;

import com.taller2.taller2.models.Libro;
import com.taller2.taller2.services.LibroServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private final LibroServices libroServices;

    public LibroController(LibroServices libroServices) {
        this.libroServices = libroServices;
    }

    @GetMapping("/findAll")
    public List<Libro> findAll() {
        return libroServices.findAll();
    }

    @PostMapping("/save")
    public Libro save(@RequestBody Libro libro) {
        return libroServices.save(libro);
    }

    @PutMapping("path/{id}")
    public Libro updateLibro(@PathVariable Long id, @RequestBody Libro entity) {
        return this.libroServices.update(id, entity);
    }

    @GetMapping("/editorial/{idEditorial}")
    public List<Libro> getLibrosByEditorial(@PathVariable Long idEditorial) {
        return libroServices.getLibrosByEditorial(idEditorial);
    }
}
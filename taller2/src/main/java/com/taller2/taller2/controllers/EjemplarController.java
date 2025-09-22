package com.taller2.taller2.controllers;

import java.util.List;
import com.taller2.taller2.services.EjemplarServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taller2.taller2.models.Ejemplar;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/ejemplares")
public class EjemplarController {

    private final EjemplarServices ejemplarServices;

    private static final String EjmplarServices = null;

    @Autowired
    private com.taller2.taller2.repository.EjemplarRepository ejemplarRepository;

    EjemplarController(EjemplarServices ejemplarServices) {
        this.ejemplarServices = ejemplarServices;
    }

    @GetMapping("/findAll")
    public List<Ejemplar> findAll() {
        return ejemplarServices.findAll();
    }

    @PostMapping("/save")
    public Ejemplar save(@RequestBody Ejemplar ejemplar) {
        return ejemplarServices.save(ejemplar);
    }

    @PutMapping("path/{id}")
    public Ejemplar updateEjemplar(@PathVariable Long id, @RequestBody Ejemplar entity) {

        return this.ejemplarServices.update(id, entity);
    }

    @GetMapping("/Libro/{idLibro}")
    public List<Ejemplar> getEjemplaresByLibro(@PathVariable Long idLibro) {
        return this.ejemplarServices.getEjemplaresByLibro(idLibro);
    }

}

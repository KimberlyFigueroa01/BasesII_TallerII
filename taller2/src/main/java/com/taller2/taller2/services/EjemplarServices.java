package com.taller2.taller2.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.taller2.taller2.models.Ejemplar;
import com.taller2.taller2.repository.EjemplarRepository;
import com.taller2.taller2.repository.LibroRepositoy;

import java.util.List;

@Service
public class EjemplarServices {

    @Autowired
    private EjemplarRepository ejemplarRepository;

    @Autowired
    private LibroRepositoy libroRepository;

    public List<Ejemplar> findAll() {
        return this.ejemplarRepository.findAll();
    }

    public Ejemplar findById(Long id) {
        return this.ejemplarRepository.findById(id).orElse(null);
    }

    public Ejemplar save(Ejemplar ejemplar) {
        return this.ejemplarRepository.save(ejemplar);
    }

    public List<Ejemplar> getEjemplaresByLibro(Long idLibro) {
        return this.ejemplarRepository.getEjemplarByLibro(idLibro);
    }

    public Ejemplar update(Long id, Ejemplar ejemplar) {
        Ejemplar existente = ejemplarRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(ejemplar, existente, "idEjemplar");
        return this.ejemplarRepository.save(existente);
    }

}

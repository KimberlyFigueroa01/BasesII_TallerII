package com.taller2.taller2.services;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taller2.taller2.models.Editorial;
import com.taller2.taller2.models.Libro;
import com.taller2.taller2.repository.EditorialRepository;
import com.taller2.taller2.repository.LibroRepositoy;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class LibroServices {

    @Autowired
    private LibroRepositoy libroRepository;

    @Autowired
    private EditorialRepository editorialRepository;

    public List<Libro> findAll() {
        return this.libroRepository.findAll();
    }

    public Libro findById(Long id) {
        return this.libroRepository.findById(id).orElse(null);
    }

    public Libro save(Libro libro) {
        Editorial editorial = editorialRepository.findById(libro.getIdEditorial().getIdEditorial()).orElse(null);
        libro.setIdEditorial(editorial);
        return this.libroRepository.save(libro);
    }

    public Libro update(Long id, Libro libro) {
        Libro existente = libroRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(libro, existente, "idLibro");
        return this.libroRepository.save(existente);
    }

    public List<Libro> getLibrosByEditorial(Long idEditorial) {
        return this.editorialRepository.getLibroByEditorial(idEditorial);
    }

    public void delete(Long id) {
        this.libroRepository.deleteById(id);
    }
}

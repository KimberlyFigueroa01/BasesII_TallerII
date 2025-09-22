package com.taller2.taller2.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.taller2.taller2.models.Editorial;
import com.taller2.taller2.models.Libro;
import com.taller2.taller2.repository.EditorialRepository;

import java.util.List;

@Service
public class EditorialServices {

    @Autowired
    private EditorialRepository editorialRepository;

    public EditorialServices(EditorialRepository editorialRepository) {
        this.editorialRepository = editorialRepository;
    }

    public List<Editorial> findAll() {
        return editorialRepository.findAll();
    }

    public Editorial findById(Long id) {
        return this.editorialRepository.findById(id).orElse(null);
    }

    public Editorial save(Editorial entity) {
        return this.editorialRepository.save(entity);
    }

    public Editorial update(Long id, Editorial editorial) {
        editorial = editorialRepository.findById(id).orElse(null);
        BeanUtils.copyProperties(editorial, editorial, "idEditorial");
        return this.editorialRepository.save(editorial);
    }

    public void deleteById(Long id) {
        this.editorialRepository.deleteById(id);
    }

    public List<Libro> getEditorialById(Long id) {
        return this.editorialRepository.getLibroByEditorial(id);
    }

}

package com.taller2.taller2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "editorial")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IDEDITORIAL")
    @SequenceGenerator(name = "SEQ_IDEDITORIAL", sequenceName = "SEQ_IDEDITORIAL", allocationSize = 1)
    @Column(name = "ID_EDITORIAL")
    private Long idEditorial;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "PAIS")
    private String pais;

    @OneToMany(mappedBy = "idEditorial")
    @JsonIgnoreProperties("idEditorial")
    private List<Libro> libros;

    public Editorial() {
    }

    public Editorial(Long idEditorial, String nombre, String pais) {
        this.idEditorial = idEditorial;
        this.nombre = nombre;
        this.pais = pais;
    }

    public Long getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Long idEditorial) {
        this.idEditorial = idEditorial;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

}

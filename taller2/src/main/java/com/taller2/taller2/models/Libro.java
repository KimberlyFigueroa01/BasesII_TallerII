package com.taller2.taller2.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "libro")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IDLIBRO")
    @SequenceGenerator(name = "SEQ_IDLIBRO", sequenceName = "SEQ_IDLIBRO", allocationSize = 1)
    @Column(name = "ID_LIBRO")
    private Long idLibro;
    @Column(name = "TITULO")
    private String titulo;
    @Column(name = "ANIO_PUBLICACION")
    private int anioPublicacion;

    @ManyToOne
    @JoinColumn(name = "ID_EDITORIAL", referencedColumnName = "ID_EDITORIAL")
    @JsonIgnoreProperties("editorial")
    public Editorial idEditorial;

    public Libro() {
    }

    public Libro(Long idLibro, String titulo, int anioPublicacion) {
        this.idLibro = idLibro;
        this.titulo = titulo;
        this.anioPublicacion = anioPublicacion;
    }

    public Long getIdLibro() {
        return idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(int anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Editorial getIdEditorial() {
        return idEditorial;
    }

    public void setIdEditorial(Editorial idEditorial) {
        this.idEditorial = idEditorial;
    }

}

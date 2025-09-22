package com.taller2.taller2.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "EJEMPLAR")
public class Ejemplar {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_IDEJEMPLAR")
    @SequenceGenerator(name = "SEQ_IDEJEMPLAR", sequenceName = "SEQ_IDEJEMPLAR", allocationSize = 1)
    @Column(name = "ID_EJEMPLAR")
    private Long idEjemplar;

    @Column(name = "CODIGO_BARRA")
    private String codigoBarra;

    @Column(name = "ESTADO")
    private String estado;

    @ManyToOne
    @JoinColumn(name = "ID_LIBRO", referencedColumnName = "ID_LIBRO")
    @JsonIgnoreProperties("libro")
    private Libro libro;

    public Ejemplar() {
    }

    public Ejemplar(Long idEjemplar, String codigoBarra, String estado, Libro libro) {
        this.idEjemplar = idEjemplar;
        this.codigoBarra = codigoBarra;
        this.estado = estado;
        this.libro = libro;
    }

    public Long getIdEjemplar() {
        return idEjemplar;
    }

    public void setIdEjemplar(Long idEjemplar) {
        this.idEjemplar = idEjemplar;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

}

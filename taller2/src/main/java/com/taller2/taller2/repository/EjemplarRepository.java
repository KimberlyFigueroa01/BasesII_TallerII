package com.taller2.taller2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.taller2.taller2.models.Ejemplar;

public interface EjemplarRepository extends JpaRepository<Ejemplar, Long> {

    @Query("SELECT e FROM Ejemplar e WHERE e.libro.idLibro = :idLibro")
    public java.util.List<Ejemplar> getEjemplarByLibro(Long idLibro);

}

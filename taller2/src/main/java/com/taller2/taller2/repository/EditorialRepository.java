package com.taller2.taller2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.taller2.taller2.models.Editorial;
import com.taller2.taller2.models.Libro;

@Repository
public interface EditorialRepository extends JpaRepository<Editorial, Long> {

    @Query("SELECT l FROM Libro l WHERE l.idEditorial.idEditorial = :idEditorial")
    List<Libro> getLibroByEditorial(@Param("idEditorial") Long idEditorial);
}

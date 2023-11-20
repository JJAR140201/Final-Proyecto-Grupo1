package com.example.demo.IRepository;

import com.example.demo.Entity.Artista;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IArtistaRepository extends IBaseRepository<Artista, Long> {
    // Consulta para obtener artistas por nombre de canción
    @Query("SELECT DISTINCT a FROM Artista a INNER JOIN a.canciones c WHERE c.nombre = :nombreCancion AND c.genero = :genero")
    List<Artista> findByCancionNombre(@Param("nombreCancion") String nombreCancion, @Param("genero") String genero);

    // Consulta para obtener un artista por ID
    @Query("SELECT a FROM Artista a WHERE a.id = :id")
    Optional<Artista> findById(@Param("id") Long id);
}

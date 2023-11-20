package com.example.demo.IRepository;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Cancion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IArtistaRepository extends IBaseRepository<Artista, Long> {

    List<Artista> findByNombreArtista(String nombreArtista);

    // Consulta para obtener un artista por ID
    @Query("SELECT a FROM Artista a WHERE a.id = :id")
    Optional<Artista> findById(@Param("id") Long id);
}

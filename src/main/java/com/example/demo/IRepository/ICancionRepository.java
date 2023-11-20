package com.example.demo.IRepository;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Cancion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICancionRepository extends IBaseRepository<Cancion, Long> {
    // Consulta para obtener artistas por nombre de canción
    @Query("SELECT DISTINCT a FROM Artista a INNER JOIN a.canciones c WHERE c.nombre = :nombreCancion AND c.genero = :genero")
    List<Cancion> findByCancionNombre(@Param("nombreCancion") String nombreCancion, @Param("genero") String genero);
}

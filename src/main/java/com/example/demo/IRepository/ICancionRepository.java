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
    @Query("SELECT DISTINCT c FROM Cancion c INNER JOIN c.artista a WHERE c.nombre = :nombreCancion AND a.genero = :genero")
    List<Cancion> findByNombreCancion(@Param("nombreCancion") String nombreCancion, @Param("genero") String genero);
}

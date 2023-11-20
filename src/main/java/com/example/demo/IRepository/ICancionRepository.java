package com.example.demo.IRepository;

import com.example.demo.Entity.Cancion;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICancionRepository extends IBaseRepository<Cancion, Long> {
    // Consulta para obtener canciones por nombre de artista
    List<Cancion> findByArtistaNombre();
}

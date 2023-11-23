package com.example.demo.IRepository;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Cancion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICancionRepository extends IBaseRepository<Cancion, Long> {
    // Consulta para buscar por nombreCancion
    @Query(value = "SELECT id, nombreCancion, artista_id FROM cancion", nativeQuery = true)
    List<Cancion> findByNombreCancion( String nombreCancion);

    // Consulta para buscar por generoCancion
    @Query(value = "SELECT id, generoCancion, artista_id FROM cancion", nativeQuery = true)
    List<Cancion> findByGeneroCancion( String generoCancion);
}

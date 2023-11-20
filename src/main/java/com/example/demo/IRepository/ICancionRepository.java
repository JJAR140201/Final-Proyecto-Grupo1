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
    @Query("SELECT c FROM Cancion c WHERE c.nombre = :nombreCancion")
    List<Cancion> findByNombreCancion(@Param("nombreCancion") String nombreCancion);

    // Consulta para buscar por generoCancion
    @Query("SELECT c FROM Cancion c WHERE c.genero = :generoCancion")
    List<Cancion> findByGeneroCancion(@Param("generoCancion") String generoCancion);

}

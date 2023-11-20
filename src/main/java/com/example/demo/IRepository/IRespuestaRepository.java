package com.example.demo.IRepository;

import com.example.demo.Entity.Respuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRespuestaRepository extends IBaseRepository<Respuesta, Long> {
    // Cambiado de findByRespuesta a findByTipoRespuesta
    @Query("SELECT r FROM Respuesta r WHERE r.tipoRespuesta = :tipoRespuesta")
    List<Respuesta> findByTipoRespuesta(@Param("tipoRespuesta") String tipoRespuesta);
}

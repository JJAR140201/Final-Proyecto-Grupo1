package com.example.demo.IRepository;

import com.example.demo.Entity.Respuesta;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IRespuestaRepository extends IBaseRepository<Respuesta, Long> {
    List<Respuesta> findByRespuesta();
}

package com.example.demo.IService;

import com.example.demo.Entity.Participante;
import com.example.demo.Entity.Respuesta;

import java.util.List;

public interface IRespuestaService extends IBaseService<Respuesta>{
    List<Respuesta> findByRespuesta();
}

package com.example.demo.IService;

import com.example.demo.Entity.Cancion;
import com.example.demo.Entity.Encuesta;

import java.util.List;

public interface IEncuestaService extends IBaseService<Encuesta>{
    List<Encuesta> findAllWithParticipantes();
}

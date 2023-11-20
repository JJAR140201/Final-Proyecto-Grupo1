package com.example.demo.IService;

import com.example.demo.Entity.Participante;

import java.util.List;

public interface IParticipanteService extends IBaseService<Participante>{

    List<Participante> findByNombreCompleto(String nombreCompleto);
}

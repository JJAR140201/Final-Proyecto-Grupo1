package com.example.demo.Service;

import com.example.demo.Entity.Participante;
import com.example.demo.Entity.Respuesta;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.IRespuestaRepository;
import com.example.demo.IService.IParticipanteService;
import com.example.demo.IService.IRespuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RespuestaService extends BaseService<Respuesta> implements IRespuestaService {
    @Autowired
    private IRespuestaRepository repository;

    @Override
    public List<Respuesta> findByTipoRespuesta(String tipoRespuesta) {
        return repository.findByTipoRespuesta(tipoRespuesta);
    }

    @Override
    protected IBaseRepository<Respuesta, Long> getRepository() {
        return repository;
    }
}

package com.example.demo.Service;

import com.example.demo.Entity.Cancion;
import com.example.demo.Entity.Encuesta;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.IEncuestaRepository;
import com.example.demo.IService.ICancionService;
import com.example.demo.IService.IEncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EncuestaService extends BaseService<Encuesta> implements IEncuestaService {
    @Autowired
    private IEncuestaRepository repository;

    @Override
    public List<Encuesta> findAllWithParticipantes() {
        return repository.findAllWithParticipantes();
    }

    @Override
    protected IBaseRepository<Encuesta, Long> getRepository() {
        return repository;
    }
}

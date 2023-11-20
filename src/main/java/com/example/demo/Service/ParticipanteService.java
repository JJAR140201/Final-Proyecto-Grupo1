package com.example.demo.Service;

import com.example.demo.Entity.Participante;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.IParticipanteRepository;
import com.example.demo.IService.IParticipanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipanteService extends BaseService<Participante> implements IParticipanteService {
    @Autowired
    private IParticipanteRepository repository;
    @Override
    public List<Participante> findByNombreCompleto(String nombreCompleto) {
        return repository.findByNombreCompleto(nombreCompleto);
    }

    @Override
    protected IBaseRepository<Participante, Long> getRepository() {
        return repository;
    }
}

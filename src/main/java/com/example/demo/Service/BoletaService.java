package com.example.demo.Service;

import com.example.demo.Entity.Boleta;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.IBoletaRepository;
import com.example.demo.IService.IBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoletaService extends BaseService<Boleta> implements IBoletaService {
    @Autowired
    private IBoletaRepository repository;

    @Override
    protected IBaseRepository<Boleta, Long> getRepository() {
        return repository;
    }

    @Override
    public Boleta findByNumeroUnico(String numeroUnico) {
        return repository.findByNumeroUnico(numeroUnico);
    }
}

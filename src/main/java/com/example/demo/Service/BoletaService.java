package com.example.demo.Service;

import com.example.demo.Entity.Boleta;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IService.IBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BoletaService extends BaseService<Boleta> implements IBoletaService {
    @Autowired
    private  IBaseRepository repository;

    @Override
    public Boleta findByNumeroUnico() {
        return repository.findByNumeroUnico();
    }

    @Override
    protected IBaseRepository<Boleta, Long> getRepository() {
        return repository;
    }
}

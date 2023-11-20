package com.example.demo.Service;

import com.example.demo.Entity.Cancion;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IRepository.ICancionRepository;
import com.example.demo.IService.ICancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CancionService extends BaseService<Cancion> implements ICancionService {
    @Autowired
    private ICancionRepository repository;
    @Override
    public List<Cancion> findByArtistaNombre() {
        return repository.findByArtistaNombre();
    }

    @Override
    protected IBaseRepository<Cancion, Long> getRepository() {
        return repository;
    }
}

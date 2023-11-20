package com.example.demo.Service;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Boleta;
import com.example.demo.Entity.Cancion;
import com.example.demo.IRepository.IArtistaRepository;
import com.example.demo.IRepository.IBaseRepository;
import com.example.demo.IService.IArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService extends BaseService<Artista> implements IArtistaService {
    @Autowired
    private IArtistaRepository repository;

    @Override
    public Optional<Artista> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Artista> findByArtistaNombre() {
        return repository.findByArtistaNombre();
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }


    @Override
    protected IBaseRepository<Artista, Long> getRepository() {
        return repository;
    }
}

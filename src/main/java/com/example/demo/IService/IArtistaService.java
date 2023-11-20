package com.example.demo.IService;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Boleta;

import java.util.List;
import java.util.Optional;

public interface IArtistaService extends IBaseService<Artista> {
    List<Artista> findByCancionNombre(String nombreCancion, String genero);
    boolean existsById(Long id);
}
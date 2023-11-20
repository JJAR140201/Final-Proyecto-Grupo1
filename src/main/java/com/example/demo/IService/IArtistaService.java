package com.example.demo.IService;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Boleta;
import com.example.demo.Entity.Cancion;

import java.util.List;
import java.util.Optional;

public interface IArtistaService extends IBaseService<Artista> {
    List<Artista> findByNombreArtista(String nombreArtista);
    boolean existsById(Long id);
}
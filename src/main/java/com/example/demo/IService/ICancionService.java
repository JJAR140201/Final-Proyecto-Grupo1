package com.example.demo.IService;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Boleta;
import com.example.demo.Entity.Cancion;

import java.util.List;

public interface ICancionService extends IBaseService<Cancion>{
    List<Cancion> findByNombreCancion(String nombreCancion);
    List<Cancion> findByGeneroCancion(String genero);
}

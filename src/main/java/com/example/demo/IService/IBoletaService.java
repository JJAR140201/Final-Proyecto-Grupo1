package com.example.demo.IService;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Boleta;

import javax.swing.*;

public interface IBoletaService extends IBaseService<Boleta>{
    Boleta findByNumeroUnico();
}

package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Artista extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreArtista")
    private String nombreArtista;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreArtista() {
        return nombreArtista;
    }

    public void setNombreArtista(String nombreArtista) {
        this.nombreArtista = nombreArtista;
    }

    public List<Cancion> getCanciones() {
        return canciones;
    }

    public void setCanciones(List<Cancion> canciones) {
        this.canciones = canciones;
    }

    public Artista(Long id, String nombreArtista, List<Cancion> canciones) {
        this.id = id;
        this.nombreArtista = nombreArtista;
        this.canciones = canciones;
    }

    public Artista() {
    }

    @JsonBackReference
    @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL)
    private List<Cancion> canciones;
}

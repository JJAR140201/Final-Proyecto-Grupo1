package com.example.demo.Entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cancion extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreCancion")
    private String nombreCancion;

    @Column(name = "genero")
    private String genero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Cancion() {
    }

    public Cancion(Long id, String nombreCancion, String genero, Artista artista, List<Respuesta> respuestas) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.genero = genero;
        this.artista = artista;
        this.respuestas = respuestas;
    }

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @OneToMany(mappedBy = "cancion", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;
}

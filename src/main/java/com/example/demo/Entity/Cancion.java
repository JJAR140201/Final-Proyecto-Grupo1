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

    @Column(name = "generoCancion")
    private String generoCancion;

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

    public String getGeneroCancion() {
        return generoCancion;
    }

    public void setGeneroCancion(String generoCancion) {
        this.generoCancion = generoCancion;
    }

    public Cancion() {
    }

    public Cancion(Long id, String nombreCancion, String generoCancion, Artista artista, List<Respuesta> respuestas) {
        this.id = id;
        this.nombreCancion = nombreCancion;
        this.generoCancion = generoCancion;
        this.artista = artista;
        this.respuestas = respuestas;
    }

    @ManyToOne
    @JoinColumn(name = "artista_id")
    private Artista artista;

    @OneToMany(mappedBy = "cancion", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;
}

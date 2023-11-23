package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "participante")
public class Participante extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreCompleto")
    private String nombreCompleto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public Encuesta getEncuesta() {
        return encuesta;
    }

    public void setEncuesta(Encuesta encuesta) {
        this.encuesta = encuesta;
    }

    public List<Respuesta> getRespuestas() {
        return respuestas;
    }

    public void setRespuestas(List<Respuesta> respuestas) {
        this.respuestas = respuestas;
    }

    public Boleta getBoleta() {
        return boleta;
    }

    public void setBoleta(Boleta boleta) {
        this.boleta = boleta;
    }

    public Participante() {
    }

    public Participante(Long id, String nombreCompleto, Encuesta encuesta, List<Respuesta> respuestas, Boleta boleta) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.encuesta = encuesta;
        this.respuestas = respuestas;
        this.boleta = boleta;
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "encuesta_id")
    private Encuesta encuesta;

    @JsonBackReference
    @OneToMany(mappedBy = "participante", cascade = CascadeType.ALL)
    private List<Respuesta> respuestas;

    @JsonBackReference
    @OneToOne(mappedBy = "participante")
    private Boleta boleta;
}

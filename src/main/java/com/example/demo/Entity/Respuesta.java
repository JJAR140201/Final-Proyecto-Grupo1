package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "respuesta")
public class Respuesta extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipoRespuesta")
    private String tipoRespuesta;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoRespuesta() {
        return tipoRespuesta;
    }

    public void setTipoRespuesta(String tipoRespuesta) {
        this.tipoRespuesta = tipoRespuesta;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Cancion getCancion() {
        return cancion;
    }

    public void setCancion(Cancion cancion) {
        this.cancion = cancion;
    }

    public Respuesta(Long id, String tipoRespuesta, Participante participante, Cancion cancion) {
        this.id = id;
        this.tipoRespuesta = tipoRespuesta;
        this.participante = participante;
        this.cancion = cancion;
    }

    public Respuesta() {
    }

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "cancion_id")
    private Cancion cancion;
}

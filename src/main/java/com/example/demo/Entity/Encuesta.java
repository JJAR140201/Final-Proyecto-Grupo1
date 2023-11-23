package com.example.demo.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Encuesta extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "tipoEncuesta")
    private String tipoEncuesta;

    @Column(name = "encuentaPregunta")
    private String encuentaPregunta;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipoEncuesta() {
        return tipoEncuesta;
    }

    public void setTipoEncuesta(String tipoEncuesta) {
        this.tipoEncuesta = tipoEncuesta;
    }

    public String getEncuentaPregunta() {
        return encuentaPregunta;
    }

    public void setEncuentaPregunta(String encuentaPregunta) {
        this.encuentaPregunta = encuentaPregunta;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public Encuesta() {
    }

    public Encuesta(Long id, String tipoEncuesta, String encuentaPregunta, List<Participante> participantes) {
        this.id = id;
        this.tipoEncuesta = tipoEncuesta;
        this.encuentaPregunta = encuentaPregunta;
        this.participantes = participantes;
    }

    @JsonBackReference
    @OneToMany(mappedBy = "encuesta", cascade = CascadeType.ALL)
    private List<Participante> participantes;
}

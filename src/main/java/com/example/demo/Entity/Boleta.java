package com.example.demo.Entity;

import jakarta.persistence.*;

@Entity
public class Boleta extends Audit{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numeroUnico")
    private String numeroUnico;
    @Column(name = "colorUnico")
    private String colorUnico;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getNumeroUnico() {
        return numeroUnico;
    }

    public void setNumeroUnico(String numeroUnico) {
        this.numeroUnico = numeroUnico;
    }

    public String getColorUnico() {
        return colorUnico;
    }

    public void setColorUnico(String colorUnico) {
        this.colorUnico = colorUnico;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Boleta(Long id, String numeroUnico, String colorUnico, Participante participante) {
        this.id = id;
        this.numeroUnico = numeroUnico;
        this.colorUnico = colorUnico;
        this.participante = participante;
    }

    public Boleta() {
    }

    @OneToOne
    @JoinColumn(name = "participante_id")
    private Participante participante;
}

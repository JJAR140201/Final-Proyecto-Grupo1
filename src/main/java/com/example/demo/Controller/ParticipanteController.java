package com.example.demo.Controller;

import com.example.demo.Entity.Participante;
import com.example.demo.IService.IParticipanteService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/participantes")
public class ParticipanteController {
    @Autowired
    private IParticipanteService participanteService;

    @GetMapping("/getAllParticipantes")
    public ResponseEntity<List<Participante>> getAllParticipantes() {
        List<Participante> participantes = participanteService.all();
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }

    @GetMapping("/getParticipanteById/{id}")
    public ResponseEntity<Participante> getParticipanteById(@PathVariable Long id) {
        Optional<Participante> participante = participanteService.findById(id);
        return participante.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByNombreCompleto")
    public ResponseEntity<List<Participante>> findByNombreCompleto(String nombreCompleto) {
        List<Participante> participantes = participanteService.findByNombreCompleto(nombreCompleto);
        return new ResponseEntity<>(participantes, HttpStatus.OK);
    }

    @PostMapping("/createParticipante")
    public ResponseEntity<Participante> createParticipante(@RequestBody Participante participante) {
        try {
            Participante createdParticipante = participanteService.save(participante);
            return new ResponseEntity<>(createdParticipante, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateParticipante/{id}")
    public ResponseEntity<Participante> updateParticipante(@PathVariable Long id, @RequestBody Participante participante) {
        try {
            participanteService.update(id, participante);
            return new ResponseEntity<>(participante, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteParticipante/{id}")
    public ResponseEntity<Void> deleteParticipante(@PathVariable Long id) {
        try {
            participanteService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

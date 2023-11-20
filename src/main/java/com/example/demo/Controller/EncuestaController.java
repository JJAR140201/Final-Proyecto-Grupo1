package com.example.demo.Controller;

import com.example.demo.Entity.Encuesta;
import com.example.demo.IService.IEncuestaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/encuestas")
public class EncuestaController {
    @Autowired
    private IEncuestaService encuestaService;

    @GetMapping("/getAllEncuestas")
    public ResponseEntity<List<Encuesta>> getAllEncuestas() {
        List<Encuesta> encuestas = encuestaService.all();
        return new ResponseEntity<>(encuestas, HttpStatus.OK);
    }

    @GetMapping("/getEncuestaById/{id}")
    public ResponseEntity<Encuesta> getEncuestaById(@PathVariable Long id) {
        Optional<Encuesta> encuesta = encuestaService.findById(id);
        return encuesta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscarConParticipantes")
    public ResponseEntity<List<Encuesta>> getEncuestasWithParticipantes() {
        List<Encuesta> encuestas = encuestaService.findAllWithParticipantes();
        return new ResponseEntity<>(encuestas, HttpStatus.OK);
    }

    @PostMapping("/createEncuesta")
    public ResponseEntity<Encuesta> createEncuesta(@RequestBody Encuesta encuesta) {
        try {
            Encuesta createdEncuesta = encuestaService.save(encuesta);
            return new ResponseEntity<>(createdEncuesta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateEncuesta/{id}")
    public ResponseEntity<Encuesta> updateEncuesta(@PathVariable Long id, @RequestBody Encuesta encuesta) {
        try {
            encuestaService.update(id, encuesta);
            return new ResponseEntity<>(encuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteEncuesta/{id}")
    public ResponseEntity<Void> deleteEncuesta(@PathVariable Long id) {
        try {
            encuestaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

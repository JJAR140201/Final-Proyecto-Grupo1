package com.example.demo.Controller;

import com.example.demo.Entity.Respuesta;
import com.example.demo.IService.IRespuestaService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin("*")
public class RespuestaController {
    @Autowired
    private IRespuestaService respuestaService;

    @GetMapping
    public ResponseEntity<List<Respuesta>> getAllRespuestas() {
        List<Respuesta> respuestas = respuestaService.all();
        return new ResponseEntity<>(respuestas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Respuesta> getRespuestaById(@PathVariable Long id) {
        Optional<Respuesta> respuesta = respuestaService.findById(id);
        return respuesta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscarPorRespuesta")
    public ResponseEntity<List<Respuesta>> getRespuestasByRespuesta() {
        List<Respuesta> respuestas = respuestaService.findByRespuesta();
        return new ResponseEntity<>(respuestas, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Respuesta> createRespuesta(@RequestBody Respuesta respuesta) {
        try {
            Respuesta createdRespuesta = respuestaService.save(respuesta);
            return new ResponseEntity<>(createdRespuesta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> updateRespuesta(@PathVariable Long id, @RequestBody Respuesta respuesta) {
        try {
            respuestaService.update(id, respuesta);
            return new ResponseEntity<>(respuesta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRespuesta(@PathVariable Long id) {
        try {
            respuestaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

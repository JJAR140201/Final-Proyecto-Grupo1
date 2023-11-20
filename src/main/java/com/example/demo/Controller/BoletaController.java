package com.example.demo.Controller;

import com.example.demo.Entity.Boleta;
import com.example.demo.IService.IBoletaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/boletas")
public class BoletaController {
    @Autowired
    private IBoletaService boletaService;

    @GetMapping
    public ResponseEntity<List<Boleta>> getAllBoletas() {
        List<Boleta> boletas = boletaService.all();
        return new ResponseEntity<>(boletas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Boleta> getBoletaById(@PathVariable Long id) {
        Optional<Boleta> boleta = boletaService.findById(id);
        return boleta.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/buscarPorNumeroUnico")
    public ResponseEntity<Boleta> getBoletaByNumeroUnico() {
        Boleta boleta = boletaService.findByNumeroUnico();
        if (boleta != null) {
            return new ResponseEntity<>(boleta, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Boleta> createBoleta(@RequestBody Boleta boleta) {
        try {
            Boleta createdBoleta = boletaService.save(boleta);
            return new ResponseEntity<>(createdBoleta, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boleta> updateBoleta(@PathVariable Long id, @RequestBody Boleta boleta) {
        try {
            boletaService.update(id, boleta);
            return new ResponseEntity<>(boleta, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoleta(@PathVariable Long id) {
        try {
            boletaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

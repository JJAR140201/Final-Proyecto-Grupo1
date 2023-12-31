package com.example.demo.Controller;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Cancion;
import com.example.demo.IService.ICancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/canciones")
public class CancionController {
    @Autowired
    private ICancionService cancionService;

    @GetMapping("/getAllCanciones")
    public ResponseEntity<List<Cancion>> getAllCanciones() {
        List<Cancion> canciones = cancionService.all();
        return new ResponseEntity<>(canciones, HttpStatus.OK);
    }

    @GetMapping("/getCancionById/{id}")
    public ResponseEntity<Cancion> getCancionById(@PathVariable Long id) {
        Optional<Cancion> cancion = cancionService.findById(id);
        return cancion.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/findByNombreCancion")
    public ResponseEntity<List<Cancion>> findByNombreCancion(
            @RequestParam(name = "nombreCancion", required = false) String nombreCancion) {
        List<Cancion> cancions = cancionService.findByNombreCancion(nombreCancion);
        return new ResponseEntity<>(cancions, HttpStatus.OK);
    }

    @GetMapping("/findByGeneroCancion")
    public ResponseEntity<List<Cancion>> findByGeneroCancion(@RequestParam(name = "generoCancion", required = false) String generoCancion){
        List<Cancion> cancions = cancionService.findByGeneroCancion(generoCancion);
        return new ResponseEntity<>(cancions, HttpStatus.OK);
    }

    @PostMapping("/createCancion")
    public ResponseEntity<Cancion> createCancion(@RequestBody Cancion cancion) {
        try {
            Cancion createdCancion = cancionService.save(cancion);
            return new ResponseEntity<>(createdCancion, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateCancion/{id}")
    public ResponseEntity<Cancion> updateCancion(@PathVariable Long id, @RequestBody Cancion cancion) {
        try {
            cancionService.update(id, cancion);
            return new ResponseEntity<>(cancion, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/deleteCancion/{id}")
    public ResponseEntity<Void> deleteCancion(@PathVariable Long id) {
        try {
            cancionService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

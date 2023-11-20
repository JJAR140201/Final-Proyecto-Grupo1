package com.example.demo.Controller;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Boleta;
import com.example.demo.Entity.Cancion;
import com.example.demo.IService.IArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/artistas")
public class ArtistaController {
    @Autowired
    private IArtistaService artistaService;

    @GetMapping("/getAllArtistas")
    public ResponseEntity<List<Artista>> getAllArtistas() {
        List<Artista> artistas = artistaService.all();
        return new ResponseEntity<>(artistas, HttpStatus.OK);
    }

    @GetMapping("/getArtistaById/{id}")
    public ResponseEntity<Artista> getArtistaById(@PathVariable Long id) {
        Optional<Artista> artista = artistaService.findById(id);
        return artista.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/getCancionesByArtistaNombre")
    public ResponseEntity<List<Artista>> getCancionesByArtistaNombre() {
        List<Artista> artistas = artistaService.findByArtistaNombre();
        return new ResponseEntity<>(artistas, HttpStatus.OK);
    }

    @PostMapping("/createArtista")
    public ResponseEntity<Artista> createArtista(@RequestBody Artista artista) throws Exception {
        Artista createdArtista = artistaService.save(artista);
        return new ResponseEntity<>(createdArtista, HttpStatus.CREATED);
    }

    @PutMapping("/updateArtista/{id}")
    public ResponseEntity<Artista> updateArtista(@PathVariable Long id, @RequestBody Artista artista) throws Exception {
        if (artistaService.existsById(id)) {
            artista.setId(id);
            Artista updatedArtista = artistaService.save(artista);
            return new ResponseEntity<>(updatedArtista, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteArtista/{id}")
    public ResponseEntity<Void> deleteArtista(@PathVariable Long id) throws Exception {
        if (artistaService.existsById(id)) {
            artistaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

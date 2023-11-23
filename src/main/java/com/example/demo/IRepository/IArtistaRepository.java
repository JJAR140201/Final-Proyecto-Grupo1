package com.example.demo.IRepository;

import com.example.demo.DTO.ConsultaDTO;
import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Cancion;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IArtistaRepository extends IBaseRepository<Artista, Long> {

    List<Artista> findByNombreArtista(String nombreArtista);

    // Consulta para obtener un artista por ID
    @Query("SELECT a FROM Artista a WHERE a.id = :id")
    Optional<Artista> findById(@Param("id") Long id);

    @Query("SELECT " +
            "p.nombreCompleto AS NombreParticipante, " +
            "e.encuentaPregunta AS PreguntaEncuesta, " +
            "r.tipoRespuesta AS TipoRespuesta, " +
            "c.nombreCancion AS NombreCancion, " +
            "a.nombreArtista AS NombreArtista, " +
            "b.colorUnico AS ColorBoleta, " +
            "b.numeroUnico AS NumeroBoleta " +
            "FROM " +
            "respuesta r " +
            "JOIN participante p ON r.participante_id = p.id " +
            "JOIN cancion c ON r.cancion_id = c.id " +
            "JOIN artista a ON c.artista_id = a.id " +
            "JOIN boleta b ON p.id = b.participante_id " +
            "JOIN encuesta e ON p.encuesta_id = e.id")
    List<ConsultaDTO> findGlobal();

}

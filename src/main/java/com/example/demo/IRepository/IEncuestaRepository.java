package com.example.demo.IRepository;

import com.example.demo.Entity.Artista;
import com.example.demo.Entity.Encuesta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IEncuestaRepository extends IBaseRepository<Encuesta, Long> {
    @Query("SELECT e FROM Encuesta e LEFT JOIN FETCH e.participantes")
    List<Encuesta> findAllWithParticipantes();
}

package com.example.demo.IRepository;

import com.example.demo.Entity.Participante;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IParticipanteRepository extends IBaseRepository<Participante, Long> {
    // Consulta para obtener participantes por color de boleta
    List<Participante> findByBoletaColorUnico();
}

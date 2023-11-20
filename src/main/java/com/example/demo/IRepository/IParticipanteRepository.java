package com.example.demo.IRepository;

import com.example.demo.Entity.Participante;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IParticipanteRepository extends IBaseRepository<Participante, Long> {
    // Consulta para obtener un participante por ID
    @Query("SELECT p FROM Participante p WHERE p.id = :id")
    Optional<Participante> findById(@Param("id") Long id);

    // Consulta para obtener participantes por nombre completo
    @Query("SELECT p FROM Participante p WHERE LOWER(p.nombreCompleto) LIKE LOWER(CONCAT('%', :nombreCompleto, '%'))")
    List<Participante> findByNombreCompleto(@Param("nombreCompleto") String nombreCompleto);
}

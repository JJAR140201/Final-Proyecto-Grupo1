package com.example.demo.IRepository;

import com.example.demo.Entity.Boleta;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IBoletaRepository extends IBaseRepository<Boleta, Long> {

    Boleta findByNumeroUnico(String numeroUnico);

    @Query("SELECT a FROM Artista a WHERE a.id = :id")
    Optional<Boleta> findById(@Param("id") Long id);
}

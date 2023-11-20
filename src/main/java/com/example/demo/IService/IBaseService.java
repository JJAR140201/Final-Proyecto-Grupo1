package com.example.demo.IService;

import com.example.demo.Entity.Audit;
import com.example.demo.Entity.Boleta;

import java.util.List;
import java.util.Optional;

public interface IBaseService <T extends Audit>{
    List<T> all();
    List<T> findByStateTrue();
    Optional<T> findById(Long id);
    T save(T entity) throws Exception;
    void update(Long id, T entity) throws Exception;
    void delete(Long id) throws Exception;
}

package com.example.demo.IRepository;

import com.example.demo.Entity.Audit;
import com.example.demo.Entity.Boleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBaseRepository<T extends Audit, ID> extends JpaRepository<T, ID> {
}

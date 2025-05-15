package com.edutech.msvc.curso.repositories;

import com.edutech.msvc.curso.models.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CursosRepository extends JpaRepository<Curso, Long>{
    Optional<Curso> findByNombre(String nombre);
}

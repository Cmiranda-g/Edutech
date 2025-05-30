package com.edutech.msvc.curso.services;

import com.edutech.msvc.curso.models.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> findAll();
    Curso findById(Long id);
    Curso save (Curso curso);
    List<Curso> findByIdProfesor(Long idProfesor);
}

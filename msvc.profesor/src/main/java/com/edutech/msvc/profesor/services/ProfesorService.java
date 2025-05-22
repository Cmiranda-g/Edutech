package com.edutech.msvc.profesor.services;

import com.edutech.msvc.profesor.models.entities.Profesor;
import com.edutech.msvc.profesor.dtos.CursoProfesorDTO;

import java.util.List;

public interface ProfesorService {

    List<Profesor> findAll();
    Profesor findById(Long id);
    Profesor save(Profesor profesor);
    CursoProfesorDTO findCursoById(Long idProfesor);

}

package com.edutech.msvc.profesor.dtos;

import com.edutech.msvc.profesor.models.Curso;
import lombok.*;

import java.util.List;

/**
 * Clase DTO para mostrar el listado de cursos que dicta un profesor
 */

@Getter @Setter @ToString
@NoArgsConstructor @AllArgsConstructor
public class CursoProfesorDTO {
    private String nombreCompleto;
    private String runProfesor;
    private List<Curso> cursos;
}

package com.edutech.msvc.curso.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.NotEmpty;


@Entity
@Table(name = "cursos")
@Getter @Setter @ToString
@AllArgsConstructor @NoArgsConstructor
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_curso")
    private Long idCurso;

    @Column(nullable = false, unique = true)
    @NotEmpty(message = "El nombre del curso no puede ser vacio")
    private String nombre;

    @Column(nullable = false)
    @NotNull(message = "El id del profesor no puede ser vacio")
    private Long idProfesor;
}

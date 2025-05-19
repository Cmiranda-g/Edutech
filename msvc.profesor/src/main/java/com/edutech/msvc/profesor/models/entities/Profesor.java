package com.edutech.msvc.profesor.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Entity
@Table(name="profesor")
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
public class Profesor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_profesor")
    private Long idProfesor;

    @Column(name = "run_profesor", nullable = false)
    @NotBlank(message = "El campo run profesor no puede ser vacio")
    @Pattern(regexp = "//d{1,8}-[//dKk]", message = "El formato del run debe ser XXXXXXX-X")
    private String runProfesor;

    @Column(name = "nombre_completo", nullable = false)
    @NotBlank(message = "El campo de nombre completo profesor no puede ser vacio")
    private String nombreCompleto;
}

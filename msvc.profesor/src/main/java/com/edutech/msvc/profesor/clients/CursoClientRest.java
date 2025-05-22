package com.edutech.msvc.profesor.clients;

import com.edutech.msvc.profesor.models.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="msvc.cruso", url="localhost:8080/api/v1/Cursos" )
public interface CursoClientRest {

    @GetMapping("/Profesor/{id}")
    List<Curso> findByIdProfesor(@PathVariable Long id);

}

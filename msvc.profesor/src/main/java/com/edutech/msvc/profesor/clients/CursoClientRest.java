package com.edutech.msvc.profesor.clients;

import com.edutech.msvc.profesor.models.Curso;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="msvc.cruso", url="localhost:8080/api/v1/Cursos" )
public interface CursoClientRest {

    @GetMapping("/{id}")
    Curso findById(@PathVariable Long id);

}

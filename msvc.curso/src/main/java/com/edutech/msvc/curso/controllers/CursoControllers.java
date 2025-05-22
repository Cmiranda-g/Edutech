package com.edutech.msvc.curso.controllers;

import com.edutech.msvc.curso.models.Curso;
import com.edutech.msvc.curso.services.CursoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Cursos")
@Validated
public class CursoControllers {
    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.cursoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.cursoService.findById(id));
    }

    @GetMapping("/Profesor/{id}")
    public ResponseEntity<List<Curso>> findByIdProfesor(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(this.cursoService.findByIdProfesor(id));
    }

    @PostMapping
    public ResponseEntity<Curso> save(@Valid @RequestBody Curso curso) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.cursoService.save(curso));
    }
}
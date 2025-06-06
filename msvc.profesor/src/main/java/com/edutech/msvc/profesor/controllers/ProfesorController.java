package com.edutech.msvc.profesor.controllers;

import com.edutech.msvc.profesor.dtos.CursoProfesorDTO;
import com.edutech.msvc.profesor.models.entities.Profesor;
import com.edutech.msvc.profesor.services.ProfesorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/Profesor")
@Validated
public class ProfesorController {

    @Autowired
    private ProfesorService profesorService;
    @GetMapping
    public ResponseEntity<List<Profesor>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(this.profesorService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Profesor> findById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.profesorService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Profesor> save(@Valid @RequestBody Profesor profesor) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.profesorService.save(profesor));
    }

}

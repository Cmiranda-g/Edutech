package com.edutech.msvc.profesor.services;

import com.edutech.msvc.profesor.clients.CursoClientRest;
import com.edutech.msvc.profesor.dtos.CursoProfesorDTO;
import com.edutech.msvc.profesor.exceptions.ProfesorException;
import com.edutech.msvc.profesor.models.Curso;
import com.edutech.msvc.profesor.models.entities.Profesor;
import com.edutech.msvc.profesor.repositories.ProfesorRepository;
import feign.FeignException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesorServiceImpl implements ProfesorService{

    @Autowired
    private ProfesorRepository profesorRepository;

    @Autowired
    private CursoClientRest cursoClientRest;

    @Override
    public List<Profesor> findAll(){
        return profesorRepository.findAll();
    }

    @Override
    public Profesor findById(Long id) {
        return profesorRepository.findById(id).orElseThrow(
                () -> new ProfesorException("El profesor con id " + id + " no se encuentra en la base de datos")
        );

    }

    @Override
    public Profesor save(Profesor profesor) {
        return profesorRepository.save(profesor);
    }

    @Override
    public CursoProfesorDTO findCursoById(Long idProfesor){
        //agregamos esto en ecaso de que no exista el medico que estamos buscando la app pueda realizar la excepcion
        Profesor profesor = this.findById(idProfesor);
        List<Curso> cursos = this.cursoClientRest.findByIdProfesor(idProfesor);

        if(!cursos.isEmpty()){
          return cursos.stream().map(curso -> )  //falta
        }
        return null;
    }

    // FALTA
}

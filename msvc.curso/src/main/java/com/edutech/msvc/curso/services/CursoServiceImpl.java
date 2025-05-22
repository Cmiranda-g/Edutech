package com.edutech.msvc.curso.services;

import com.edutech.msvc.curso.exceptions.CursoException;
import com.edutech.msvc.curso.models.Curso;
import com.edutech.msvc.curso.repositories.CursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService{
    @Autowired
    private CursosRepository cursosRepository;

    @Override
    public List<Curso> findAll(){
        return this.cursosRepository.findAll();
    }

    @Override
    public Curso findById(Long id) {
        return this.cursosRepository.findById(id).orElseThrow(()-> new CursoException("El curso con el id: " + id+" no se encuentra en la base de datos"));
    }


    @Override
    public Curso save(Curso curso){
        if(this.cursosRepository.findByNombre(curso.getNombre()).isPresent()){
            throw new CursoException("El curso con el nombre: " + curso.getNombre() + " ya existe en la base de datos");
        }
        return this.cursosRepository.save(curso);
    }

    @Override
    public List<Curso> findByIdProfesor(Long idProfesor) {
        return this.cursosRepository.findByIdProfesor(idProfesor);
    }
}

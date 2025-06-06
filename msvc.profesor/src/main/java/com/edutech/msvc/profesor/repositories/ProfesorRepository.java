package com.edutech.msvc.profesor.repositories;

import com.edutech.msvc.profesor.models.entities.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesorRepository extends JpaRepository<Profesor, Long>{
}

package com.edutech.msvc.profesor.exceptions;

import com.edutech.msvc.profesor.dtos.ErrorDTO;
import com.edutech.msvc.profesor.models.entities.Profesor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // Se crea un metodo privado que permite generar el error DTO con los elementos basicos del error

    private ErrorDTO createErrorDto(int status, Date date, Map<String, String> errorMap){
        ErrorDTO errorDTO = new ErrorDTO();

        errorDTO.setStatus(status);
        errorDTO.setDate(date);
        errorDTO.setErrors(errorMap);

        return errorDTO;

    }
    /**
     * De esta forma se permite capturar los mensajes de error en caso que los argumenteos que fueron solicitado, no
     * cumplan con la condicion de valitaion que fue generadoa futuro.
     *a @param exception
     *a @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorDTO> handValidationFields(MethodArgumentNotValidException exception){
        Map<String,String> errorMap = new HashMap<>();
        for (FieldError fieldError : exception.getBindingResult().getFieldErrors()){
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(this.createErrorDto(HttpStatus.BAD_REQUEST.value(), new Date(), errorMap));
    }

    @ExceptionHandler(ProfesorException.class)
    public ResponseEntity<ErrorDTO> handleCursoException(ProfesorException exception){
        if (exception.getMessage().contains("no se encuentra en la base de datos")){
            //Esto no sirve para cuando no existe el curso
            Map<String, String> errorMap = Collections.singletonMap("Curso no encontrado", exception.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(this.createErrorDto(HttpStatus.NOT_FOUND.value(), new Date(), errorMap));

        }else{
            //Esto sirve cuando el curso ya esta creado en la base de datos
            Map<String, String> errorMap = Collections.singletonMap("Curso ya existente", exception.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(this.createErrorDto(HttpStatus.CONFLICT.value(), new Date(), errorMap));
        }
    }

}

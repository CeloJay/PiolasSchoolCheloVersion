package com.br.piolaschool.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.br.piolaschool.entidade.aluno.Aluno;
import com.br.piolaschool.services.AlunoService;

import jakarta.validation.Valid;
import repository.IAluno;

@RestController
@RequestMapping("/aluno")
public class AlunoController{

    @Autowired
    private IAluno repository;

    private AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/aluno")
    @ResponseBody
    public ResponseEntity<List<Aluno>> listaAlunos(){
        return ResponseEntity.status(200).body(alunoService.listaAluno());
    }

    @PostMapping("/cadastro")
    @ResponseBody
    public ResponseEntity<Aluno> criarAluno(@Valid @RequestBody Aluno aluno){
        return ResponseEntity.status(201).body(alunoService.criarAluno(aluno));
    }

    @PutMapping
    @ResponseBody
    public ResponseEntity<Aluno> editarAluno(@Valid @RequestBody Aluno aluno){
        return ResponseEntity.status(200).body(alunoService.editarAluno(aluno));
    }    

    @DeleteMapping("/{matricula}")
    public ResponseEntity<?> deletarAluno(@PathVariable Integer matricula){
        alunoService.deletarAluno(matricula);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/login")
    @ResponseBody
    public ResponseEntity<Aluno> validarSenha(@Valid @RequestBody Aluno aluno){
        Boolean valid = alunoService.validarSenha(aluno);
        if(!valid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(200).build();
    } 

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationException(MethodArgumentNotValidException ex){
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        return errors;
    }


}

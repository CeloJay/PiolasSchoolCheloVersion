package com.br.piolaschool.controllers;

import java.util.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.piolaschool.entidade.professor.Professor;
import com.br.piolaschool.services.ProfessorService;

import repository.IProfessor;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    
    @Autowired
    private IProfessor repository; 

    private ProfessorService professorService;

    public ProfessorController(ProfessorService professorService){
        this.professorService = professorService;
    }

    @GetMapping
    public ResponseEntity<List<Professor>> listaProfessores() {
        return ResponseEntity.status(200).body(professorService.listaProfessor()); 
    }

    @PostMapping("/cadastroprofessor")
    public ResponseEntity<Professor> criarProfessor(@RequestBody Professor professor){
        return ResponseEntity.status(201).body(professorService.criarProfessor(professor));
    }

    @PutMapping
    public ResponseEntity<Professor> editarProfessor(@RequestBody Professor professor){
        return ResponseEntity.status(200).body(professorService.editarProfessor(professor));
    }

    @DeleteMapping
    public ResponseEntity<?> deletarProfessor(@PathVariable Integer matricula){
        professorService.deletarProfessor(matricula);
        return ResponseEntity.status(204).build(); 
    }

    @PostMapping("/loginprof")
    public ResponseEntity<Professor> validarSenha(@RequestBody Professor professor){
        Boolean valid = professorService.validarSenha(professor);
        if(!valid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(200).build();
    }
}

package com.br.piolaschool.controllers;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.piolaschool.entidade.curso.Curso;
import com.br.piolaschool.services.CursoService;

import repository.ICurso;

import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/curso")
public class CursoController {
    
    @Autowired
    private ICurso repository;

    private CursoService cursoService;
    
    @GetMapping
    public ResponseEntity<List<Curso>> listaCurso(){
        return ResponseEntity.status(200).body(cursoService.listaCurso());
    }

    @PostMapping
    public ResponseEntity<Curso> criarCurso(@RequestBody Curso curso){
        return ResponseEntity.status(201).body(cursoService.criarCurso(curso));
    }

    @PutMapping
    public ResponseEntity<Curso> editarCurso(@RequestBody Curso curso){
        return ResponseEntity.status(200).body(cursoService.editarCurso(curso));
    }

    @DeleteMapping
    public ResponseEntity<?> deletarCurso(@PathVariable Integer codigo){
        cursoService.deletarCurso(codigo); 
        return ResponseEntity.status(204).build();
    }
}

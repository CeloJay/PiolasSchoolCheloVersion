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

import com.br.piolaschool.entidade.administrador.Administrador;
import com.br.piolaschool.services.AdministradorService;

import jakarta.validation.Valid;
import repository.IAdministrador;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
    
    @Autowired
    private IAdministrador repository;

    private AdministradorService administradorService;

    public AdministradorController(AdministradorService administradorService){
        this.administradorService = administradorService;
    }
    
    @GetMapping
    public ResponseEntity<List<Administrador>> listaAdministrador() {
        return ResponseEntity.status(200).body(administradorService.listaAdministrador()); 
    }

    @PostMapping("/cadastroadm")
    public ResponseEntity<Administrador> criarAdministrador(@Valid @RequestBody Administrador administrador){
        return ResponseEntity.status(201).body(administradorService.criarAdministrador(administrador));
    }

    @PutMapping
    public ResponseEntity<Administrador> editarAdministrador(@Valid @RequestBody Administrador administrador){
        return ResponseEntity.status(200).body(administradorService.editarAdministrador(administrador));
    }

    @DeleteMapping
    public ResponseEntity<?> deletarAdministrador(@PathVariable Integer matricula){
        administradorService.deletarAdministrador(matricula);
        return ResponseEntity.status(204).build();
    }

    @PostMapping("/loginadm")
    public ResponseEntity<Administrador> validarSenha(@Valid @RequestBody Administrador administrador){
        Boolean valid = administradorService.validarSenha(administrador);
        if(!valid){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        return ResponseEntity.status(200).build();
    } 
}

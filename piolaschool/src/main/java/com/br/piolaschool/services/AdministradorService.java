package com.br.piolaschool.services;

import java.util.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.piolaschool.entidade.administrador.Administrador;

import repository.IAdministrador;

@Service
public class AdministradorService {
    
    private final IAdministrador repository;
    private final PasswordEncoder passwordEncoder;

    public AdministradorService (IAdministrador repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Administrador> listaAdministrador(){
        List<Administrador> lista = (List<Administrador>) repository.findAll();
        return lista;
    }

    public Administrador criarAdministrador(Administrador administrador){
        String encoder = this.passwordEncoder.encode(administrador.getSenha());
        administrador.setSenha(encoder);
        Administrador administradorNovo = repository.save(administrador);
        return administradorNovo;
    }

    public Administrador editarAdministrador(Administrador administrador){
        String encoder = this.passwordEncoder.encode(administrador.getSenha());
        administrador.setSenha(encoder);
        Administrador administradorNovo = repository.save(administrador);
        return administradorNovo;
    }

    public Boolean deletarAdministrador(Integer matricula){
        repository.deleteById(matricula);
        return true;
    }

    public Boolean validarSenha(Administrador administrador){
        String senha = repository.getById(administrador.getMatricula()).getSenha();
        Boolean valid = passwordEncoder.matches(administrador.getSenha(), senha);
        return valid;
    }
}

package com.br.piolaschool.services;

import java.util.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.piolaschool.entidade.professor.Professor;

import repository.IProfessor;

@Service
public class ProfessorService {
    
    private final IProfessor repository;
    private final PasswordEncoder passwordEncoder;

    public ProfessorService(IProfessor repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Professor> listaProfessor(){
        List<Professor> lista = (List<Professor>) repository.findAll();
        return lista;
    }

    public Professor criarProfessor(Professor professor){
        String encoder = this.passwordEncoder.encode(professor.getSenha());
        professor.setSenha(encoder);
        Professor professorNovo = repository.save(professor);
        return professorNovo;
    }

    public Professor editarProfessor(Professor professor){
        String encoder = this.passwordEncoder.encode(professor.getSenha());
        professor.setSenha(encoder);
        Professor professorNovo = repository.save(professor);
        return professorNovo;
    }

    public Boolean deletarProfessor(Integer matricula){
        repository.deleteById(matricula);
        return true;
    }

    public Boolean validarSenha(Professor professor){
        String senha = repository.getById(professor.getMatricula()).getSenha();
        Boolean valid = passwordEncoder.matches(professor.getSenha(), senha);
        return valid;
    }
}

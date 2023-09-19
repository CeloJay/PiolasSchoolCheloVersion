package com.br.piolaschool.services;

import java.util.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.br.piolaschool.entidade.aluno.Aluno;
import repository.IAluno;

@Service
public class AlunoService {
    
    private final IAluno repository;
    private final PasswordEncoder passwordEncoder;

    public AlunoService (IAluno repository){
        this.repository = repository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public List<Aluno> listaAluno(){
        List<Aluno> lista = (List<Aluno>) repository.findAll();
        return lista;
    }

    public Aluno criarAluno(Aluno aluno){
        String encoder = this.passwordEncoder.encode(aluno.getSenha());
        aluno.setSenha(encoder);
        Aluno alunoNovo = repository.save(aluno);
        return alunoNovo;
    }

    public Aluno editarAluno(Aluno aluno){
        String encoder = this.passwordEncoder.encode(aluno.getSenha());
        aluno.setSenha(encoder);
        Aluno alunoNovo = repository.save(aluno);
        return alunoNovo;
    }

    public Boolean deletarAluno(Integer matricula){
        repository.deleteById(matricula);
        return true;
    }

    public Boolean validarSenha(Aluno aluno){
        String senha = repository.getById(aluno.getMatricula()).getSenha();
        Boolean valid = passwordEncoder.matches(aluno.getSenha(), senha);
        return valid;
    }

}

package com.br.piolaschool.services;

import java.util.*;

import org.springframework.stereotype.Service;

import com.br.piolaschool.entidade.curso.Curso;

import repository.ICurso;

@Service
public class CursoService {
    
    private final ICurso repository;

    public CursoService(ICurso repository){
        this.repository = repository;
    }

    public List<Curso> listaCurso(){
        List<Curso> lista = (List<Curso>) repository.findAll();
        return lista;
    }

    public Curso criarCurso(Curso curso){
        Curso cursoNovo = repository.save(curso);
        return cursoNovo;
    }

    public Curso editarCurso(Curso curso){
        Curso cursoNovo = repository.save(curso);
        return cursoNovo;
    }

    public Boolean deletarCurso(Integer codigo){
        repository.deleteById(codigo);
        return true;
    }

}

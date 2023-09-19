package com.br.piolaschool.entidade.curso;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "curso")
@Entity(name = "curso")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Curso {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private String nome;

    private Long numeroalunos;

    private Long tarefas;

    private Long aulas;



}

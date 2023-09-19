package com.br.piolaschool.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AlunoDTO {

    private String nome_completo;
    private String email;
    private String senha;

    public AlunoDTO(String nome_completo, String email, String senha){
        super();
        this.nome_completo = nome_completo;
        this.email = email;
        this.senha = senha;
    }

}

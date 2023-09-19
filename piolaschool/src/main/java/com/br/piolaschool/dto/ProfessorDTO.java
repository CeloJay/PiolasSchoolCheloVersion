package com.br.piolaschool.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProfessorDTO {
    private String usuario;
    private String email;
    private String senha;

    public ProfessorDTO(String usuario, String email, String senha){
        super();
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;
    }
}

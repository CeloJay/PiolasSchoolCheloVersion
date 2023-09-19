package com.br.piolaschool.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AdministradorDTO {
    private String usuario;
    private String email;
    private String senha;

    public AdministradorDTO(String usuario, String email, String senha){
        super();
        this.usuario = usuario;
        this.email = email;
        this.senha = senha;

    }

}

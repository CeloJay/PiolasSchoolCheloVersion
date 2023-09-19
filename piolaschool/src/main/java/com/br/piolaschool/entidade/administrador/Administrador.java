package com.br.piolaschool.entidade.administrador;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "administrador")
@Entity(name = "administrador")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "matricula")
public class Administrador {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "matricula", length = 20, nullable = true)
    private Long matricula;

    @NotBlank(message = "Este campo é obrigatório")
    @Column(name = "usuario", length = 255, nullable = true)
    private String usuario;

    @Email(message = "Insira um e-mail válido")
    @NotBlank(message = "Este campo é obrigatório")
    @Column(name = "email", length = 255, nullable = true)
    private String email;

    @Size(min = 6, message = "Mínimo de 6 caracteres")
    @NotBlank(message = "Este campo é obrigatório")
    @Column(name = "senha", length = 255, nullable = true)
    private String senha;

    @NotBlank(message = "Este campo é obrigatório")
    @Column(name = "telefone", length = 14, nullable = true)
    private String telefone;

    
}

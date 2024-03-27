package com.juancassemiro.lojavirtualapi.model;


import com.juancassemiro.lojavirtualapi.dto.UsuarioCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.UsuarioDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String login;
    private String senha;
    @Column(length = 11)
    private String cpf;
    private String email;
    private String endereco;
    private String cep;
    private Date dataCriacao;
    private Date dataAtualizacao;

    public Usuario(){

    }
    public Usuario(UsuarioCadastroDto dto) {
        this.login = dto.login();
        this.senha = dto.senha();
    }

    public Usuario(UsuarioDto dto){
        this.id = dto.id();
        this.login = dto.login();
        this.senha = dto.senha();
    }
}

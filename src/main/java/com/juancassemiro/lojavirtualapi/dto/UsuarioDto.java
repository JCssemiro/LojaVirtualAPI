package com.juancassemiro.lojavirtualapi.dto;

import com.juancassemiro.lojavirtualapi.model.Cidade;
import com.juancassemiro.lojavirtualapi.model.Usuario;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record UsuarioDto(@NotNull Long id,
                         @NotNull String login,
                         @NotNull String senha,
                         @NotNull String cpf,
                         @NotNull String email ,
                         @NotNull String endereco,
                         @NotNull String cep,
                         @NotNull Cidade cidade,
                         @NotNull Date dataCriacao,
                         @NotNull Date dataAtualizacao) {

    public UsuarioDto(Usuario usuario){
        this(usuario.getId(),
                usuario.getLogin(),
                usuario.getSenha(),
                usuario.getCpf(),
                usuario.getEmail(),
                usuario.getEndereco(),
                usuario.getCep(),
                usuario.getCidade(),
                usuario.getDataCriacao(),
                usuario.getDataAtualizacao());
    }

}

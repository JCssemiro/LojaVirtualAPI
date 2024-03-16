package com.juancassemiro.lojavirtualapi.dto;

import com.juancassemiro.lojavirtualapi.model.Cidade;
import com.juancassemiro.lojavirtualapi.model.Estado;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CidadeDto(@NotNull Long id, @NotNull String nome, @NotNull Estado estado, @NotNull Date dataCriacao, @NotNull Date dataAtualizacao) {
    public CidadeDto(Cidade cidade){
        this(cidade.getId(), cidade.getNome(), cidade.getEstado(),cidade.getDataCriacao(),cidade.getDataAtualizacao());
    }
}

package com.juancassemiro.lojavirtualapi.dto;

import com.juancassemiro.lojavirtualapi.model.Estado;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record EstadoDto(@NotNull Long id,@NotNull String nome,@NotNull String sigla,@NotNull Date dataCriacao,@NotNull Date dataAtualizacao) {

    public EstadoDto(Estado estado){
        this(estado.getId(), estado.getNome(), estado.getSigla(), estado.getDataCriacao(),estado.getDataAtualizacao());
    }
}

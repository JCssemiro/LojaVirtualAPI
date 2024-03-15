package com.juancassemiro.lojavirtualapi.dto;

import com.juancassemiro.lojavirtualapi.model.Marca;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record MarcaDto(@NotNull Long id, @NotNull String nome, @NotNull Date dataCriacao, @NotNull Date dataAtualizacao) {
    public MarcaDto(Marca marca){
        this(marca.getId(),marca.getNome(),marca.getDataCriacao(),marca.getDataAtualizacao());
    }
}

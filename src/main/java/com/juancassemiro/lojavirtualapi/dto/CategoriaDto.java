package com.juancassemiro.lojavirtualapi.dto;

import com.juancassemiro.lojavirtualapi.model.Categoria;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CategoriaDto(@NotNull Long id, @NotNull String nome,@NotNull Date dataCriacao,@NotNull Date dataAtualizacao) {
    public CategoriaDto(Categoria categoria){
        this(categoria.getId(), categoria.getNome(), categoria.getDataCriacao(),categoria.getDataAtualizacao());
    }
}

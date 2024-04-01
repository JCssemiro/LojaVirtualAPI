package com.juancassemiro.lojavirtualapi.dto;

import com.juancassemiro.lojavirtualapi.model.Produto;
import com.juancassemiro.lojavirtualapi.model.ProdutoImagem;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProdutoImagemDto(@NotNull Long id, @NotNull String nome, @NotNull Produto produto) {
    public ProdutoImagemDto(ProdutoImagem dto){
        this(dto.getId(), dto.getNome(), dto.getProduto());
    }
}

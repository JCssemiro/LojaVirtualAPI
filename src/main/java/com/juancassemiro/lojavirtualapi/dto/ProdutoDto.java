package com.juancassemiro.lojavirtualapi.dto;

import com.juancassemiro.lojavirtualapi.model.Categoria;
import com.juancassemiro.lojavirtualapi.model.Marca;
import com.juancassemiro.lojavirtualapi.model.Produto;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProdutoDto(@NotNull Long id,
                         @NotNull String nome,
                         @NotNull String descricao,
                         @NotNull Double valorCusto,
                         @NotNull Double valorVenda,
                         @NotNull Marca marca,
                         @NotNull Categoria categoria,
                         @NotNull Date dataCriacao,
                         @NotNull Date dataAtualizacao) {
    public ProdutoDto(Produto produto){
        this(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getValorCusto(), produto.getValorVenda(), produto.getMarca(),produto.getCategoria(),produto.getDataCriacao(),produto.getDataAtualizacao());
    }
}

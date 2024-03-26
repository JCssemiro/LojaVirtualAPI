package com.juancassemiro.lojavirtualapi.dto;

import com.juancassemiro.lojavirtualapi.model.Categoria;
import com.juancassemiro.lojavirtualapi.model.Marca;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record ProdutoCadastroDto(
        @NotNull String nome,
        @NotNull String descricao,
        @NotNull Double valorCusto,
        @NotNull Double valorVenda,
        @NotNull Marca marca,
        @NotNull Categoria categoria
) {
}

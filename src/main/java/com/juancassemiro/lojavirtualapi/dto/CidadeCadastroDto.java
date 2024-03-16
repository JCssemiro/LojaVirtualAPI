package com.juancassemiro.lojavirtualapi.dto;

import com.juancassemiro.lojavirtualapi.model.Estado;
import jakarta.validation.constraints.NotNull;

import java.util.Date;

public record CidadeCadastroDto(@NotNull String nome, @NotNull Estado estado) {
}

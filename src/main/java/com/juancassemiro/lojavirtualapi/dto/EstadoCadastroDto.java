package com.juancassemiro.lojavirtualapi.dto;

import jakarta.validation.constraints.NotNull;

public record EstadoCadastroDto(@NotNull String nome,@NotNull String sigla) {

}

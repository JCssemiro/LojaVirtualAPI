package com.juancassemiro.lojavirtualapi.dto;

import jakarta.validation.constraints.NotNull;

public record UsuarioCadastroDto(@NotNull String login, @NotNull String senha,@NotNull String cpf,@NotNull String email ,@NotNull String endereco,@NotNull String cep) {
}

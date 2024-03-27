package com.juancassemiro.lojavirtualapi.repository;


import com.juancassemiro.lojavirtualapi.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}

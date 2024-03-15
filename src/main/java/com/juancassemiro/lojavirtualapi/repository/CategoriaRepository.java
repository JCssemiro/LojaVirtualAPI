package com.juancassemiro.lojavirtualapi.repository;

import com.juancassemiro.lojavirtualapi.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}

package com.juancassemiro.lojavirtualapi.repository;

import com.juancassemiro.lojavirtualapi.model.Categoria;
import com.juancassemiro.lojavirtualapi.model.Marca;
import com.juancassemiro.lojavirtualapi.model.Produto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository extends JpaRepository<Produto,Long> {


    Boolean existsByMarca(Marca marca);
    Boolean existsByCategoria(Categoria categoria);

    List<Produto> findByMarca(Marca marca);

    List<Produto> findByCategoria(Categoria categoria);
}

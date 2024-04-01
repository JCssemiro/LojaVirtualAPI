package com.juancassemiro.lojavirtualapi.repository;

import com.juancassemiro.lojavirtualapi.model.Produto;
import com.juancassemiro.lojavirtualapi.model.ProdutoImagem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProdutoImagemRepository extends JpaRepository<ProdutoImagem,Long> {
    void deleteByNome(String nome);

     List<ProdutoImagem> findAllByProduto(Produto produto);
}

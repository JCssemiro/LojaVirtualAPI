package com.juancassemiro.lojavirtualapi.service;

import com.juancassemiro.lojavirtualapi.dto.ProdutoCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.ProdutoDto;
import com.juancassemiro.lojavirtualapi.model.Categoria;
import com.juancassemiro.lojavirtualapi.model.Marca;
import com.juancassemiro.lojavirtualapi.model.Produto;
import com.juancassemiro.lojavirtualapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoDto> listarTodosProdutos(){
        try {
            return produtoRepository.findAll().stream().map(ProdutoDto::new).toList();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public ProdutoDto listarProdutoPorId(Long id) {
        try {
            return new ProdutoDto(produtoRepository.findById(id).get());
        } catch (RuntimeException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<ProdutoDto> listarProdutosPorMarcaOuCategoria(Marca marca, Categoria categoria){
        try{
            if(marca != null){
                return produtoRepository.findByMarca(marca).stream().map(ProdutoDto::new).toList();
            }else if(categoria != null){
                return produtoRepository.findByCategoria(categoria).stream().map(ProdutoDto::new).toList();
            }else{
                throw new RuntimeException("Não foi possível encontrar nenhum produto com a marca ou categoria informada!");
            }
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public ProdutoDto cadastrarProduto(ProdutoCadastroDto dto){
        try{
            Produto produtoCadastrado = new Produto(dto);
            return new ProdutoDto(produtoRepository.save(produtoCadastrado));
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public ProdutoDto editarProduto(ProdutoDto dto){
        try{
            Produto produtoEditado = produtoRepository.save(new Produto(dto));
            return new ProdutoDto(produtoEditado);

        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarProdutoPorId(Long id){
        try{
            produtoRepository.deleteById(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }


}

package com.juancassemiro.lojavirtualapi.controler;


import com.juancassemiro.lojavirtualapi.dto.ProdutoCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.ProdutoDto;
import com.juancassemiro.lojavirtualapi.model.Categoria;
import com.juancassemiro.lojavirtualapi.model.Marca;
import com.juancassemiro.lojavirtualapi.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;


    @GetMapping
    public ResponseEntity listarProdutos(@RequestParam(value = "marca",required = false)Marca marca, @RequestParam(value="categoria",required = false) Categoria categoria){
        try{
            if(marca != null || categoria != null) {
                List<ProdutoDto> listaProdutos = produtoService.listarProdutosPorMarcaOuCategoria(marca, categoria);
                return ResponseEntity.ok(listaProdutos);
            }else{
                List<ProdutoDto> listaProdutos = produtoService.listarTodosProdutos();
                return ResponseEntity.ok(listaProdutos);
            }
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity listarProdutoPorId(@PathVariable Long id){
        try{
            ProdutoDto produtoEncontrado = produtoService.listarProdutoPorId(id);
            return ResponseEntity.ok(produtoEncontrado);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity cadastrarProduto(@RequestBody @Valid ProdutoCadastroDto dto, UriComponentsBuilder uriBuilder){
        try{
            ProdutoDto produtoCadastrado = produtoService.cadastrarProduto(dto);
            URI uri = uriBuilder.path("/produto/{id}").buildAndExpand(produtoCadastrado.id()).toUri();
            return ResponseEntity.created(uri).body(produtoCadastrado);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity editarProduto(@RequestBody ProdutoDto dto){
        try{
            ProdutoDto produtoEditado = produtoService.editarProduto(dto);
            return ResponseEntity.ok(produtoEditado);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarProdutoPorId(@PathVariable Long id){
        try{
            produtoService.deletarProdutoPorId(id);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());

        }
    }

}

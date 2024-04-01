package com.juancassemiro.lojavirtualapi.controler;


import com.juancassemiro.lojavirtualapi.dto.ProdutoImagemDto;
import com.juancassemiro.lojavirtualapi.model.Marca;
import com.juancassemiro.lojavirtualapi.model.Produto;
import com.juancassemiro.lojavirtualapi.service.ProdutoImagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/produtoImagem")
public class ProdutoImagemController {

    @Autowired
    private ProdutoImagemService service;

    @GetMapping
    public ResponseEntity listarTodasImagens(@RequestParam(value = "produto",required = false) Long idProduto){
        try {
            List<ProdutoImagemDto> listaImagens;
            if(idProduto != null) {
                listaImagens = service.listarImagensPorProduto(idProduto);
                return ResponseEntity.ok(listaImagens);
            }else{
                System.out.println("Produto nulo!");
                listaImagens = service.listarTodasImagens();
                return ResponseEntity.ok(listaImagens);
            }
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        }

        @GetMapping("/{id}")
        public ResponseEntity listarImagemPorId(@PathVariable Long id){
        try{
            ProdutoImagemDto imagem = service.listarImagemPorId(id);
            return ResponseEntity.ok(imagem);
        }catch (RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
        }
        @PostMapping
    public ResponseEntity cadastrarImagem(@RequestParam("produtoId")Long id, @RequestParam("file") MultipartFile file, UriComponentsBuilder uriBuilder){
        try{
            ProdutoImagemDto imagemCadastrada = service.salvarImagem(id,file);
            URI uri = uriBuilder.path("/produtoImagem/{id}").buildAndExpand(imagemCadastrada.id()).toUri();
            return ResponseEntity.created(uri).body(imagemCadastrada);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarImagemPorId(@PathVariable Long id){
        try{
            service.deletarImagem(id);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

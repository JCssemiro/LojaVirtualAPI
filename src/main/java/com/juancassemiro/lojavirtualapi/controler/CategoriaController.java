package com.juancassemiro.lojavirtualapi.controler;

import com.juancassemiro.lojavirtualapi.dto.CategoriaCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.CategoriaDto;
import com.juancassemiro.lojavirtualapi.service.CategoriaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity ListarTodasCategorias(){
        try{
            List<CategoriaDto> listaCategorias = categoriaService.listarTodasCategorias();
            return ResponseEntity.status(HttpStatus.OK).body(listaCategorias);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity listarCategoriaPorId(@PathVariable Long id){
        try{
            CategoriaDto categoriaEncontrada = categoriaService.listarCategoriaPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(categoriaEncontrada);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity cadastrarCategoria(@RequestBody @Valid CategoriaCadastroDto dto, UriComponentsBuilder uriBuilder){
        try{
            CategoriaDto categoriaCadastrada = categoriaService.cadastrarCategoria(dto);
            URI uri = uriBuilder.path("/categoria/{id}").buildAndExpand(categoriaCadastrada.id()).toUri();
            return ResponseEntity.created(uri).body(categoriaCadastrada);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity editarCategoria(@RequestBody @Valid CategoriaDto dto){
        try{
            CategoriaDto categoriaAlterada = categoriaService.alterarCategoria(dto);
            return ResponseEntity.status(HttpStatus.OK).body(categoriaAlterada);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCategoria(@PathVariable Long id){
        try{
            categoriaService.excluirCategoriaPorId(id);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

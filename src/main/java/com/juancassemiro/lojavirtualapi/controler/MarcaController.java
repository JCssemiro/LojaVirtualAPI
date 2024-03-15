package com.juancassemiro.lojavirtualapi.controler;

import com.juancassemiro.lojavirtualapi.dto.MarcaCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.MarcaDto;
import com.juancassemiro.lojavirtualapi.model.Marca;
import com.juancassemiro.lojavirtualapi.service.MarcaService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/marca")
public class MarcaController {

    @Autowired
    MarcaService marcaService;
    @GetMapping
    public ResponseEntity listarTodasMarcas(){
        try{
            List<MarcaDto> listaMarcas = marcaService.listarTodasMarcas();
            return ResponseEntity.status(HttpStatus.OK).body(listaMarcas);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity listarMarcaPorId(@PathVariable Long id){
        try{
            MarcaDto marcaEncontrada = marcaService.listarMarcaPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(marcaEncontrada);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity cadastrarMarca(@RequestBody @Valid MarcaCadastroDto dto, UriComponentsBuilder uriBuilder){
        try{
            MarcaDto marcaCadastrada = marcaService.cadastrarMarca(dto);
            URI uri = uriBuilder.path("/marca/{id}").buildAndExpand(marcaCadastrada.id()).toUri();
            return ResponseEntity.created(uri).body(marcaCadastrada);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity editarMarca(@RequestBody @Valid MarcaDto dto){
        try{
            MarcaDto marcaAlterada = marcaService.alterarMarca(dto);
            return ResponseEntity.status(HttpStatus.OK).body(marcaAlterada);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarMarcaPorId(@PathVariable Long id){
        try{
            marcaService.deletarMarcaPorId(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

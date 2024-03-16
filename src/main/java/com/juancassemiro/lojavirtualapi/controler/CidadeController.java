package com.juancassemiro.lojavirtualapi.controler;


import com.juancassemiro.lojavirtualapi.dto.CidadeCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.CidadeDto;
import com.juancassemiro.lojavirtualapi.service.CidadeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @GetMapping
    public ResponseEntity listarTodasCidades(){
        try{
            List<CidadeDto> listaCidades = cidadeService.listarTodasCidades();
            return ResponseEntity.status(HttpStatus.OK).body(listaCidades);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity listarCidadePorId(@PathVariable Long id){
        try{
            CidadeDto cidadeEncontrada = cidadeService.listarCidadePorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(cidadeEncontrada);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity cadastrarCidade(@RequestBody @Valid CidadeCadastroDto dto, UriComponentsBuilder uriBuilder){
        try{
            CidadeDto cidadeCadastrada = cidadeService.cadastrarCidade(dto);
            URI uri = uriBuilder.path("/cidade/{id}").buildAndExpand(cidadeCadastrada.id()).toUri();
            return ResponseEntity.created(uri).body(cidadeService.listarCidadePorId(cidadeCadastrada.id()));

        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity editarCidade(@RequestBody @Valid CidadeDto dto){
        try{
            CidadeDto cidadeEditada = cidadeService.alterarCidade(dto);
            return ResponseEntity.ok(cidadeEditada);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarCidadePorId(@PathVariable Long id){
        try{
            cidadeService.deletarCidadePorId(id);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

package com.juancassemiro.lojavirtualapi.controler;

import com.juancassemiro.lojavirtualapi.dto.EstadoCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.EstadoDto;
import com.juancassemiro.lojavirtualapi.service.EstadoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoController {

    @Autowired
    private EstadoService estadoService;

    @GetMapping
    public ResponseEntity listarEstados(){
        try{
            List<EstadoDto> listaEstados = estadoService.listarTodosEstados();
            return ResponseEntity.status(HttpStatus.OK).body(listaEstados);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity listarEstadoPorId(@PathVariable Long id){
        try{
            EstadoDto estadoEncontrado = estadoService.listarEstadoPorId(id);
            return ResponseEntity.status(HttpStatus.OK).body(estadoEncontrado);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity cadastrarEstado(@RequestBody @Valid EstadoCadastroDto dto, UriComponentsBuilder uriBuilder){
        try{
            EstadoDto estadoNovo = estadoService.cadastrarEstado(dto);
            URI uri = uriBuilder.path("/estado/{id}").buildAndExpand(estadoNovo.id()).toUri();
            return ResponseEntity.created(uri).body(estadoNovo);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity alterarEstado(@RequestBody @Valid EstadoDto dto){
        try{
            EstadoDto estadoAlterado = estadoService.alterarEstado(dto);
            return ResponseEntity.status(HttpStatus.OK).body(estadoAlterado);
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarEstado(@PathVariable Long id){
        try{
            estadoService.deletarEstadoPorId(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}

package com.juancassemiro.lojavirtualapi.controler;


import com.juancassemiro.lojavirtualapi.dto.UsuarioCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.UsuarioDto;
import com.juancassemiro.lojavirtualapi.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity listarTodosUsuarios() {
        try {
            List<UsuarioDto> listaUsuarios = usuarioService.listarUsuarios();
            return ResponseEntity.ok(listaUsuarios);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity listarUsuarioPorId(@PathVariable Long id) {
        try {
            UsuarioDto usuarioEncontrado = usuarioService.listarUsuarioPorId(id);
            return ResponseEntity.ok(usuarioEncontrado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity cadastrarUsuario(@RequestBody @Valid UsuarioCadastroDto dto, UriComponentsBuilder uriBuilder) {
        try {
            UsuarioDto usuarioCadastrado = usuarioService.cadastrarUsuario(dto);
            URI uri = uriBuilder.path("/usuario/{id}").buildAndExpand(usuarioCadastrado.id()).toUri();
            return ResponseEntity.created(uri).body(usuarioCadastrado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity editarUsuario(@RequestBody @Valid UsuarioDto dto) {
        try {
            UsuarioDto usuarioEditado = usuarioService.editarUsuario(dto);
            return ResponseEntity.ok(usuarioEditado);
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deletarUsuarioPorId(@PathVariable Long id){
        try{
            usuarioService.deletarUsuarioPorId(id);
            return ResponseEntity.noContent().build();
        }catch(RuntimeException e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

}
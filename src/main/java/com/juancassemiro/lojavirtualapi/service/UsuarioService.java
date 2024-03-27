package com.juancassemiro.lojavirtualapi.service;

import com.juancassemiro.lojavirtualapi.dto.UsuarioCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.UsuarioDto;
import com.juancassemiro.lojavirtualapi.model.Usuario;
import com.juancassemiro.lojavirtualapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDto> listarUsuarios(){
        try{
            return usuarioRepository.findAll().stream().map(UsuarioDto::new).toList();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public UsuarioDto listarUsuarioPorId(Long id){
        try{
            return new UsuarioDto(usuarioRepository.findById(id).get());
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public UsuarioDto cadastrarUsuario(UsuarioCadastroDto dto){
        try{
            return new UsuarioDto(usuarioRepository.save(new Usuario(dto)));
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public UsuarioDto editarUsuario(UsuarioDto dto){
        try{
            return new UsuarioDto(usuarioRepository.save(new Usuario(dto)));
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarUsuarioPorId(Long id){
        try{
            usuarioRepository.deleteById(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}

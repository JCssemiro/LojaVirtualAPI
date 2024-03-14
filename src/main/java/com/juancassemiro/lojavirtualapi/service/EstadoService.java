package com.juancassemiro.lojavirtualapi.service;


import com.juancassemiro.lojavirtualapi.dto.EstadoCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.EstadoDto;
import com.juancassemiro.lojavirtualapi.model.Estado;
import com.juancassemiro.lojavirtualapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public List<EstadoDto> listarTodosEstados(){
        try{
            return estadoRepository.findAll().stream().map(EstadoDto::new).toList();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public EstadoDto listarEstadoPorId(Long id){
        try{
            return new EstadoDto(estadoRepository.findById(id).get());
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public EstadoDto cadastrarEstado(EstadoCadastroDto dto){
        try {
            Estado estadoCadastrado = new Estado(dto);
            estadoRepository.save(estadoCadastrado);
            return new EstadoDto(estadoCadastrado);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public EstadoDto alterarEstado(EstadoDto dto){
        try {
            return new EstadoDto(estadoRepository.save(new Estado(dto)));
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarEstadoPorId(Long id){
        try{
            estadoRepository.deleteById(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}

package com.juancassemiro.lojavirtualapi.service;

import com.juancassemiro.lojavirtualapi.dto.MarcaCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.MarcaDto;
import com.juancassemiro.lojavirtualapi.model.Marca;
import com.juancassemiro.lojavirtualapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {

    @Autowired
    private MarcaRepository marcaRepository;
    public List<MarcaDto> listarTodasMarcas(){
        try{
            return marcaRepository.findAll().stream().map(MarcaDto::new).toList();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public MarcaDto listarMarcaPorId(Long id){
        try{
            return new MarcaDto(marcaRepository.findById(id).get());
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public MarcaDto cadastrarMarca(MarcaCadastroDto dto){
        try{
            Marca marcaCadastrada = marcaRepository.save(new Marca(dto));
            return new MarcaDto(marcaCadastrada);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public MarcaDto alterarMarca(MarcaDto dto){
        try{
            Marca marcaAlterada = marcaRepository.save(new Marca(dto));
            return new MarcaDto(marcaAlterada);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarMarcaPorId(Long id){
        try{
            marcaRepository.deleteById(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
}

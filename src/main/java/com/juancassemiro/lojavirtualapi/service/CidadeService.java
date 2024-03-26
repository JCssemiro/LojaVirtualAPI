package com.juancassemiro.lojavirtualapi.service;

import com.juancassemiro.lojavirtualapi.dto.CidadeCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.CidadeDto;
import com.juancassemiro.lojavirtualapi.model.Cidade;
import com.juancassemiro.lojavirtualapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {
    @Autowired
    private CidadeRepository cidadeRepository;

    public List<CidadeDto> listarTodasCidades(){
        try {
            return cidadeRepository.findAll().stream().map(CidadeDto::new).toList();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
        }
    public CidadeDto listarCidadePorId(Long id){
        try{
            return new CidadeDto(cidadeRepository.findById(id).get());
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public CidadeDto cadastrarCidade(CidadeCadastroDto dto){
        try{
            Cidade cidadeCadastrada = new Cidade(dto);
            return new CidadeDto(cidadeRepository.save(cidadeCadastrada));
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public CidadeDto alterarCidade(CidadeDto dto){
        try{
            Cidade cidadeAlterada = cidadeRepository.save(new Cidade(dto));
            return new CidadeDto(cidadeAlterada);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarCidadePorId(Long id){
        try{
            cidadeRepository.deleteById(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}



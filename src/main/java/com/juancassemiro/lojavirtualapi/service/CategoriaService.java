package com.juancassemiro.lojavirtualapi.service;

import com.juancassemiro.lojavirtualapi.dto.CategoriaCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.CategoriaDto;
import com.juancassemiro.lojavirtualapi.model.Categoria;
import com.juancassemiro.lojavirtualapi.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaDto> listarTodasCategorias(){
        try {
            return categoriaRepository.findAll().stream().map(CategoriaDto::new).toList();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public CategoriaDto listarCategoriaPorId(Long id){
        try{
            return new CategoriaDto(categoriaRepository.findById(id).get());
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public CategoriaDto cadastrarCategoria(CategoriaCadastroDto dto){
        try{
            Categoria novaCategoria = new Categoria(dto);
            return new CategoriaDto(categoriaRepository.save(novaCategoria));
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public CategoriaDto alterarCategoria(CategoriaDto dto){
        try{
            Categoria categoriaEditada = new Categoria(dto);
            return new CategoriaDto(categoriaRepository.save(categoriaEditada));
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void excluirCategoriaPorId(Long id){
        try{
            categoriaRepository.deleteById(id);
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}

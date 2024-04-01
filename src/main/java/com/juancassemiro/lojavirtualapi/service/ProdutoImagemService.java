package com.juancassemiro.lojavirtualapi.service;

import com.juancassemiro.lojavirtualapi.dto.ProdutoImagemDto;
import com.juancassemiro.lojavirtualapi.model.Produto;
import com.juancassemiro.lojavirtualapi.model.ProdutoImagem;
import com.juancassemiro.lojavirtualapi.repository.ProdutoImagemRepository;
import com.juancassemiro.lojavirtualapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Service
public class  ProdutoImagemService {

    @Autowired
    private ProdutoImagemRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoImagemDto> listarTodasImagens(){
        try {
            return repository.findAll().stream().map(ProdutoImagemDto::new).toList();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }


    public List<ProdutoImagemDto> listarImagensPorProduto(Long idProduto) {
        try{
            Produto produto = produtoRepository.findById(idProduto).get();
            return repository.findAllByProduto(produto).stream().map(ProdutoImagemDto::new).toList();
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }
    public ProdutoImagemDto listarImagemPorId(Long id){
        try{
            return new ProdutoImagemDto(repository.findById(id).get());
        }catch(RuntimeException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public ProdutoImagemDto salvarImagem(Long produtoId, MultipartFile file){
        try{
            Produto produto = produtoRepository.findById(produtoId).get();
            ProdutoImagem imagem = new ProdutoImagem();
            if(!file.isEmpty()){
                byte[] bytes = file.getBytes();
                String nomeArquivo = String.valueOf(produtoId)+file.getOriginalFilename();
                Path path = Paths.get("c:/images/"+nomeArquivo);
                Files.write(path,bytes);
                imagem.setNome(nomeArquivo);
            }
            imagem.setProduto(produto);
            imagem = repository.save(imagem);
            return new ProdutoImagemDto(imagem);
        }catch(RuntimeException | IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

    public void deletarImagem(Long id){
        try{
            ProdutoImagem imagem = repository.findById(id).get();
            repository.delete(imagem);
            Files.delete(Paths.get("c:/images/"+imagem.getNome()));
        }catch(RuntimeException | IOException e){
            throw new RuntimeException(e.getMessage());
        }
    }

}

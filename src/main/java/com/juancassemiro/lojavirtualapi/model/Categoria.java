package com.juancassemiro.lojavirtualapi.model;

import com.juancassemiro.lojavirtualapi.dto.CategoriaCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.CategoriaDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public Categoria(){

    }

    public Categoria(CategoriaCadastroDto dto) {
        this.nome = dto.nome();
        this.dataCriacao = new Date();
        this.dataAtualizacao = new Date();
    }

    public Categoria(CategoriaDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.dataCriacao = dto.dataCriacao();
        this.dataAtualizacao = new Date();
    }
}

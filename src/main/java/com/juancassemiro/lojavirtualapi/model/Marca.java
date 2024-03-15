package com.juancassemiro.lojavirtualapi.model;

import com.juancassemiro.lojavirtualapi.dto.MarcaCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.MarcaDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="marca")
public class Marca {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String nome;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public Marca(){

    }
    public Marca(MarcaCadastroDto dto) {
        this.nome = dto.nome();
        this.dataCriacao = new Date();
        this.dataAtualizacao = new Date();
    }
    public Marca(MarcaDto marcaAlterada){
        this.id = marcaAlterada.id();
        this.nome = marcaAlterada.nome();
        this.dataCriacao = marcaAlterada.dataCriacao();
        this.dataAtualizacao = new Date();
    }
}

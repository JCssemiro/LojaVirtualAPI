package com.juancassemiro.lojavirtualapi.model;


import com.juancassemiro.lojavirtualapi.dto.CidadeCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.CidadeDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
@Table(name="cidade")
public class Cidade {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome",unique = true)
    private String nome;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    @ManyToOne
    @JoinColumn(name="estado_id", referencedColumnName = "id")
    private Estado estado;

    public Cidade(){

    }
    public Cidade(CidadeCadastroDto dto) {
        this.nome = dto.nome();
        this.estado = dto.estado();
        this.dataCriacao = new Date();
        this.dataAtualizacao = new Date();
    }

    public Cidade(CidadeDto dto){
        this.id = dto.id();
        this.nome = dto.nome();
        this.estado = dto.estado();
        this.dataCriacao = dto.dataCriacao();
        this.dataAtualizacao = new Date();
    }
}

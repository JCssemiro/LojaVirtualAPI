package com.juancassemiro.lojavirtualapi.model;

import com.juancassemiro.lojavirtualapi.dto.EstadoCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.EstadoDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;


@Data
@Entity
@Table(name="estado")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name="sigla" ,unique = true)
    private String sigla;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public Estado(){}
    public Estado(EstadoCadastroDto dto){
        this.nome = dto.nome();
        this.sigla = dto.sigla();
        this.dataCriacao = new Date();
        this.dataAtualizacao = new Date();
    }

    public Estado(EstadoDto EstadoAlterado) {
        this.id = EstadoAlterado.id();
        this.nome = EstadoAlterado.nome();
        this.sigla = EstadoAlterado.sigla();
        this.dataCriacao = EstadoAlterado.dataCriacao();
        this.dataAtualizacao = new Date();
    }
}

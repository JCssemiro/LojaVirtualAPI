package com.juancassemiro.lojavirtualapi.model;


import com.juancassemiro.lojavirtualapi.dto.ProdutoCadastroDto;
import com.juancassemiro.lojavirtualapi.dto.ProdutoDto;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="produto")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;
    @Column(columnDefinition = "TEXT")
    private String descricao;
    private Double valorCusto;
    private Double valorVenda;

    @ManyToOne
    @JoinColumn(name="marca_id",referencedColumnName = "id")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name="categoria_id",referencedColumnName = "id")
    private Categoria categoria;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataAtualizacao;

    public Produto(){

    }

    public Produto(ProdutoCadastroDto dto) {
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.valorCusto = dto.valorCusto();
        this.valorVenda = dto.valorVenda();
        this.marca = dto.marca();
        this.categoria = dto.categoria();
        this.dataCriacao = new Date();
        this.dataAtualizacao = new Date();
    }

    public Produto(ProdutoDto dto) {
        this.id = dto.id();
        this.nome = dto.nome();
        this.descricao = dto.descricao();
        this.valorCusto = dto.valorCusto();
        this.valorVenda = dto.valorVenda();
        this.marca = dto.marca();
        this.categoria = dto.categoria();
        this.dataCriacao = dto.dataCriacao();
        this.dataAtualizacao = new Date();
    }
}

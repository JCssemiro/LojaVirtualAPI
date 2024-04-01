package com.juancassemiro.lojavirtualapi.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name="produto_imagem")
public class ProdutoImagem {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String nome;

    @ManyToOne
    @JoinColumn(name="produto_id",referencedColumnName = "id")
    private Produto produto;

    public ProdutoImagem(){

    };

}

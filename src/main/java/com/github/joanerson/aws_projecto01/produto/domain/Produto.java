package com.github.joanerson.aws_projecto01.produto.domain;

import com.github.joanerson.aws_projecto01.produto.application.api.request.AtualizaProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@Entity
@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"codigo"})
        }
)
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idProduto;

    @Column(length = 32, nullable = false)
    private String nome;

    @Column(length = 24, nullable = false)
    private String modelo;

    @Column(length = 8, nullable = false)
    private String codigo;

    private float preco;

    public Produto(NovoProdutoRequest novoProdutoRequest) {
        this.nome = novoProdutoRequest.nome();
        this.modelo = novoProdutoRequest.modelo();
        this.codigo = novoProdutoRequest.codigo();
        this.preco = novoProdutoRequest.preco();
    }

    public void edita(AtualizaProdutoRequest produtoRequest) {
        this.nome = produtoRequest.nome();
        this.modelo = produtoRequest.modelo();
        this.codigo = produtoRequest.codigo();
        this.preco = produtoRequest.preco();
    }
}
package com.github.joanerson.aws_projecto01.produto.domain;

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
    @Column(columnDefinition = "uuid", updatable = false, unique = true, nullable = false)
    private UUID idProduto;

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
}
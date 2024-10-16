package com.github.joanerson.aws_projecto01.produto.application.api.response;

import com.github.joanerson.aws_projecto01.produto.domain.Produto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Getter
@ToString
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoListResponse {
    private UUID idProduto;
    private String nome;
    private String modelo;
    private String codigo;
    private float preco;

    public ProdutoListResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nome = produto.getNome();
        this.modelo = produto.getModelo();
        this.codigo = produto.getCodigo();
        this.preco = produto.getPreco();
    }

    public static List<ProdutoListResponse> converte(Iterable<Produto> produtos){
        return StreamSupport.stream(produtos.spliterator(), false)
                .map(ProdutoListResponse::new)
                .collect(Collectors.toList());    }
}
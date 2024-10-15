package com.github.joanerson.aws_projecto01.produto.application.api.response;

import com.github.joanerson.aws_projecto01.produto.domain.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@Getter
@ToString
@NoArgsConstructor
public class ProdutoResponse {
    private UUID idProduto;
    private String nome;
    private String modelo;
    private String codigo;
    private float preco;

    public ProdutoResponse(Produto produto) {
        this.idProduto = produto.getIdProduto();
        this.nome = produto.getNome();
        this.modelo = produto.getModelo();
        this.codigo = produto.getCodigo();
        this.preco = produto.getPreco();
    }
}

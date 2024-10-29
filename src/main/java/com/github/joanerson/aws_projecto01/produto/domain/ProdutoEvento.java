package com.github.joanerson.aws_projecto01.produto.domain;

import jakarta.persistence.Column;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProdutoEvento {
    private Long idProduto;
    private String codigo;
    private String nomeUsuario;

    public ProdutoEvento(Produto produto, String nomeUsuario) {
        this.idProduto = produto.getIdProduto();
        this.codigo = produto.getCodigo();
        this.nomeUsuario = nomeUsuario;
    }
}
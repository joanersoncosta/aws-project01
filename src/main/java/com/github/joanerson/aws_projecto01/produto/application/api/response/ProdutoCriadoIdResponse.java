package com.github.joanerson.aws_projecto01.produto.application.api.response;


import com.github.joanerson.aws_projecto01.produto.domain.Produto;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.UUID;

@ToString
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ProdutoCriadoIdResponse {
    private Long idProduto;

    public ProdutoCriadoIdResponse(Produto produto){
        this.idProduto = produto.getIdProduto();
    }

}
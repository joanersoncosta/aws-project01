package com.github.joanerson.aws_projecto01.produto.application.service;

import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;

public interface ProdutoService {
    ProdutoCriadoIdResponse criaNovoProduto(NovoProdutoRequest novoProdutoRequest);
}

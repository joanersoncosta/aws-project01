package com.github.joanerson.aws_projecto01.produto.application.service;

import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoListResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoResponse;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {
    ProdutoCriadoIdResponse criaNovoProduto(NovoProdutoRequest novoProdutoRequest);
    ProdutoResponse buscaProdutoPorId(UUID idProduto);
    List<ProdutoListResponse> listaDeProdutos();
    ProdutoResponse buscaProdutoPorCodigo(String codigo);
}
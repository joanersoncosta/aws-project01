package com.github.joanerson.aws_projecto01.produto.application.service;

import com.github.joanerson.aws_projecto01.produto.application.api.request.AtualizaProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoListResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoResponse;

import java.util.List;
import java.util.UUID;

public interface ProdutoService {
    ProdutoCriadoIdResponse criaNovoProduto(NovoProdutoRequest novoProdutoRequest);
    ProdutoResponse buscaProdutoPorId(Long idProduto);
    List<ProdutoListResponse> listaDeProdutos();
    ProdutoResponse buscaProdutoPorCodigo(String codigo);
    void deletaProdutoPorId(Long idProduto);
    void autualizaProduto(Long idProduto, AtualizaProdutoRequest produtoRequest);
}
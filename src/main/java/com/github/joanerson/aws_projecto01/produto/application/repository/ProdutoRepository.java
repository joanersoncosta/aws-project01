package com.github.joanerson.aws_projecto01.produto.application.repository;

import com.github.joanerson.aws_projecto01.produto.domain.Produto;

import java.util.List;
import java.util.UUID;

public interface ProdutoRepository {
    Produto salva(Produto produto);
    Produto buscaProdutoPorId(UUID idProduto);
    Iterable<Produto> listaDeProdutos();
}
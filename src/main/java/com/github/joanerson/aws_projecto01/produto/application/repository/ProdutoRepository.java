package com.github.joanerson.aws_projecto01.produto.application.repository;

import com.github.joanerson.aws_projecto01.produto.domain.Produto;

public interface ProdutoRepository {
    Produto salva(Produto produto);
}
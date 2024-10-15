package com.github.joanerson.aws_projecto01.produto.application.api.request;

import jakarta.persistence.Column;

public record NovoProdutoRequest(
        String nome,
        String modelo,
        String codigo,
        float preco
) { }
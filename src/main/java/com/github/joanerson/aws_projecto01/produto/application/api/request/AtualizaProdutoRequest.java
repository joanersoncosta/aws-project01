package com.github.joanerson.aws_projecto01.produto.application.api.request;

public record AtualizaProdutoRequest(
        String nome,
        String modelo,
        String codigo,
        float preco
) { }
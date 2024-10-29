package com.github.joanerson.aws_projecto01.produto.domain;

import com.github.joanerson.aws_projecto01.produto.domain.enuns.EventType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class ProdutoEnvelope {
    private EventType eventType;
    private String data;

    public ProdutoEnvelope(EventType eventType, String data) {
        this.eventType = eventType;
        this.data = data;
    }

    public void converteParaJson(String produtoEvento) {
        data = produtoEvento;
    }
}
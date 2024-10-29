package com.github.joanerson.aws_projecto01.produto.infra;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.Topic;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.joanerson.aws_projecto01.handler.APIException;
import com.github.joanerson.aws_projecto01.produto.domain.Produto;
import com.github.joanerson.aws_projecto01.produto.domain.ProdutoEnvelope;
import com.github.joanerson.aws_projecto01.produto.domain.ProdutoEvento;
import com.github.joanerson.aws_projecto01.produto.domain.enuns.EventType;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class ProdutoSnsPublisher {
    private final AmazonSNS amazonSNS;
    private final Topic productEventstopic;
    private final ObjectMapper objectMapper;

    public ProdutoSnsPublisher(AmazonSNS amazonSNS, @Qualifier("productEventsTopic") Topic productEventstopic, ObjectMapper objectMapper) {
        this.amazonSNS = amazonSNS;
        this.productEventstopic = productEventstopic;
        this.objectMapper = objectMapper;
    }

    public void publicaEvento(ProdutoEvento produtoEvento, EventType eventType){
        log.info("[start] ProdutoSnsPublisher - publicaEvento");
        try {
            enviaMensagem(new ProdutoEnvelope(eventType, objectMapper.writeValueAsString(produtoEvento)));
        } catch (JsonProcessingException e) {
            throw APIException.build(HttpStatus.BAD_REQUEST, "Erro ao enviar mensagem!", e);
        }
        log.info("[finish] ProdutoSnsPublisher - publicaEvento");
    }

    private void enviaMensagem(ProdutoEnvelope produtoEnvelope) throws JsonProcessingException {
        log.info("[start] ProdutoSnsPublisher - enviaMensagem");
        log.info("[produtoEnvelope] : {}", produtoEnvelope.toString());
        amazonSNS.publish(
                productEventstopic.getTopicArn(),
                objectMapper.writeValueAsString(produtoEnvelope));
        log.info("[finish] ProdutoSnsPublisher - enviaMensagem");
    }
}
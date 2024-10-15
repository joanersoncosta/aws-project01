package com.github.joanerson.aws_projecto01.produto.application.api;

import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;
import com.github.joanerson.aws_projecto01.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class ProdutoRestController implements ProdutoAPI {
    private final ProdutoService produtoService;

    @Override
    public ProdutoCriadoIdResponse criaNovoProduto(NovoProdutoRequest novoProdutoRequest) {
        log.info("[start] ProdutoRestController - criaNovoProduto");
        ProdutoCriadoIdResponse produtoCriadoIdResponse = produtoService.criaNovoProduto(novoProdutoRequest);
        log.info("[finish] ProdutoRestController - criaNovoProduto");
        return produtoCriadoIdResponse;
    }
}

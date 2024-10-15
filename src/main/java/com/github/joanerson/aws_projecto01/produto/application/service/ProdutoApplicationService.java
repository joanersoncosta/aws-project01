package com.github.joanerson.aws_projecto01.produto.application.service;

import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;
import com.github.joanerson.aws_projecto01.produto.application.repository.ProdutoRepository;
import com.github.joanerson.aws_projecto01.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService{
    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoCriadoIdResponse criaNovoProduto(NovoProdutoRequest novoProdutoRequest) {
        log.info("[start] ProdutoApplicationService - criaNovoProduto");
        Produto produto = produtoRepository.salva(new Produto(novoProdutoRequest));
        log.info("[finish] ProdutoApplicationService - criaNovoProduto");
        return null;
    }
}
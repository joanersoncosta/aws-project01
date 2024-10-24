package com.github.joanerson.aws_projecto01.produto.application.api;

import com.github.joanerson.aws_projecto01.produto.application.api.request.AtualizaProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoListResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoResponse;
import com.github.joanerson.aws_projecto01.produto.application.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

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

    @Override
    public ProdutoResponse buscaProdutoPorId(Long idProduto) {
        log.info("[start] ProdutoRestController - buscaProdutoPorId");
        ProdutoResponse produtoResponse = produtoService.buscaProdutoPorId(idProduto);
        log.info("[finish] ProdutoRestController - buscaProdutoPorId");
        return produtoResponse;
    }

    @Override
    public List<ProdutoListResponse> listaDeProdutos() {
        log.info("[start] ProdutoRestController - listaDeProdutos");
        List<ProdutoListResponse> produtosResponse = produtoService.listaDeProdutos();
        log.info("[finish] ProdutoRestController - listaDeProdutos");
        return produtosResponse;
    }


    @Override
    public ProdutoResponse buscaProdutoPorCodigo(String codigo) {
        log.info("[start] ProdutoRestController - buscaProdutoPorCodigo");
        ProdutoResponse produtoResponse = produtoService.buscaProdutoPorCodigo(codigo);
        log.info("[finish] ProdutoRestController - buscaProdutoPorCodigo");
        return null;
    }

    @Override
    public void deletaProdutoPorId(Long idProduto) {
        log.info("[start] ProdutoRestController - deletaProdutoPorId");
        produtoService.deletaProdutoPorId(idProduto);
        log.info("[finish] ProdutoRestController - deletaProdutoPorId");
    }

    @Override
    public void autualizaProdutoPorId(Long idProduto, AtualizaProdutoRequest produtoRequest) {
        log.info("[start] ProdutoRestController - autualizaProdutoPorId");
        ProdutoResponse produtoResponse = produtoService.autualizaProduto(idProduto, produtoRequest);
        log.info("[finish] ProdutoRestController - autualizaProdutoPorId");
    }

}

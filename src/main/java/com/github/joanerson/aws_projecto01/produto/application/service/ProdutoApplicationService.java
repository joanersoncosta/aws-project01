package com.github.joanerson.aws_projecto01.produto.application.service;

import com.github.joanerson.aws_projecto01.produto.application.api.request.AtualizaProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoListResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoResponse;
import com.github.joanerson.aws_projecto01.produto.application.repository.ProdutoRepository;
import com.github.joanerson.aws_projecto01.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Log4j2
@RequiredArgsConstructor
public class ProdutoApplicationService implements ProdutoService{
    private final ProdutoRepository produtoRepository;

    @Override
    public ProdutoCriadoIdResponse criaNovoProduto(NovoProdutoRequest novoProdutoRequest) {
        log.info("[start] ProdutoApplicationService - criaNovoProduto");
        log.info("[novoProdutoRequest] {}", novoProdutoRequest);
        Produto produto = produtoRepository.salva(new Produto(novoProdutoRequest));
        log.info("[finish] ProdutoApplicationService - criaNovoProduto");
        return new ProdutoCriadoIdResponse(produto);
    }

    @Override
    public ProdutoResponse buscaProdutoPorId(Long idProduto) {
        log.info("[start] ProdutoApplicationService - buscaProdutoPorId");
        Produto produto = detalhaProduto(idProduto);
        log.info("[finish] ProdutoApplicationService - buscaProdutoPorId");
        return new ProdutoResponse(produto);
    }

    @Override
    public List<ProdutoListResponse> listaDeProdutos() {
        log.info("[start] ProdutoApplicationService - listaDeProdutos");
        Iterable<Produto> produtos = produtoRepository.listaDeProdutos();
        log.info("[finish] ProdutoApplicationService - listaDeProdutos");
        return ProdutoListResponse.converte(produtos);
    }

    @Override
    public ProdutoResponse buscaProdutoPorCodigo(String codigo) {
        log.info("[start] ProdutoApplicationService - buscaProdutoPorCodigo");
        log.info("[codigo] {}", codigo);
        Produto produto = produtoRepository.buscaProdutoPorCodigo(codigo);
        log.info("[finish] ProdutoApplicationService - buscaProdutoPorCodigo");
        return null;
    }

    @Override
    public void deletaProdutoPorId(Long idProduto) {
        log.info("[start] ProdutoApplicationService - deletaProdutoPorId");
        Produto produto = detalhaProduto(idProduto);
        produtoRepository.deletaProduto(produto);
        log.info("[finish] ProdutoApplicationService - deletaProdutoPorId");
    }

    public Produto detalhaProduto(Long idProduto) {
        log.info("[start] ProdutoApplicationService - detalhaProduto");
        log.info("[idProduto] {}", idProduto);
        Produto produto = produtoRepository.buscaProdutoPorId(idProduto);
        log.info("[finish] ProdutoApplicationService - detalhaProduto");
        return produto;
    }

    @Override
    public void autualizaProduto(Long idProduto, AtualizaProdutoRequest produtoRequest) {
        log.info("[start] ProdutoApplicationService - autualizaProduto");
        Produto produto = detalhaProduto(idProduto);
        produto.edita(produtoRequest);
        produtoRepository.salva(produto);
        log.info("[finish] ProdutoApplicationService - autualizaProduto");
    }

}
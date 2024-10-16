package com.github.joanerson.aws_projecto01.produto.infra;

import com.github.joanerson.aws_projecto01.handler.APIException;
import com.github.joanerson.aws_projecto01.produto.application.repository.ProdutoRepository;
import com.github.joanerson.aws_projecto01.produto.domain.Produto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
public class ProdutoInfraRepository implements ProdutoRepository {
    private final ProdutoSpringDataJpaRepository produtoSpringDataJpaRepository;

    @Override
    public Produto salva(Produto produto) {
        log.info("[start] ProdutoInfraRepository - salva");
        try {
            produtoSpringDataJpaRepository.save(produto);
        } catch (Exception e) {
            log.info("Erro ao salvar produto: {}", e.getMessage());
            throw APIException.build(HttpStatus.BAD_REQUEST, "Este produto já existe", e);
        }
        log.info("[finish] ProdutoInfraRepository - salva");
        return produto;
    }

    @Override
    public Produto buscaProdutoPorId(UUID idProduto) {
        log.info("[start] ProdutoInfraRepository - buscaProdutoPorId");
        Produto produto = produtoSpringDataJpaRepository.findById(idProduto)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado com este ID: " + idProduto));
        log.info("[finish] ProdutoInfraRepository - buscaProdutoPorId");
        return produto;
    }

    @Override
    public Iterable<Produto> listaDeProdutos() {
        log.info("[start] ProdutoInfraRepository - listaDeProdutos");
        Iterable<Produto> produtos = produtoSpringDataJpaRepository.findAll();
        log.info("[finish] ProdutoInfraRepository - listaDeProdutos");
        return produtos;
    }

    @Override
    public Produto buscaProdutoPorCodigo(String codigo) {
        log.info("[start] ProdutoInfraRepository - buscaProdutoPorCodigo");
        Produto produto = produtoSpringDataJpaRepository.findByCodigo(codigo)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND, "Produto não encontrado com este ID: " + codigo));
        log.info("[finish] ProdutoInfraRepository - buscaProdutoPorCodigo");
        return null;
    }

}
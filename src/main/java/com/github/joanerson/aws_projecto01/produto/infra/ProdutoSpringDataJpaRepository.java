package com.github.joanerson.aws_projecto01.produto.infra;

import com.github.joanerson.aws_projecto01.produto.domain.Produto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProdutoSpringDataJpaRepository extends CrudRepository<Produto, UUID> {
    Optional<Produto> findByCodigo(String codigo);
}
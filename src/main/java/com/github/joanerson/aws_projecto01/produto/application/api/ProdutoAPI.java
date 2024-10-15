package com.github.joanerson.aws_projecto01.produto.application.api;

import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/produto")
public interface ProdutoAPI {

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    ProdutoCriadoIdResponse criaNovoProduto(@RequestBody NovoProdutoRequest novoProdutoRequest);

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{idProduto}")
    ProdutoResponse buscaProdutoPorId(@PathVariable(name = "idProduto") UUID idProduto);

}
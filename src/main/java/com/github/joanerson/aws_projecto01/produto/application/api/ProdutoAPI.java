package com.github.joanerson.aws_projecto01.produto.application.api;

import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produto")
public interface ProdutoAPI {

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    ProdutoCriadoIdResponse criaNovoProduto(@RequestBody NovoProdutoRequest novoProdutoRequest);

}
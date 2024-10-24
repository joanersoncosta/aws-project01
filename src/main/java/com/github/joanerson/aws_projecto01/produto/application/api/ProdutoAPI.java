package com.github.joanerson.aws_projecto01.produto.application.api;

import com.github.joanerson.aws_projecto01.produto.application.api.request.AtualizaProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.request.NovoProdutoRequest;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoCriadoIdResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoListResponse;
import com.github.joanerson.aws_projecto01.produto.application.api.response.ProdutoResponse;
import jakarta.websocket.server.PathParam;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/produto")
public interface ProdutoAPI {

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    ProdutoCriadoIdResponse criaNovoProduto(@RequestBody NovoProdutoRequest novoProdutoRequest);

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{idProduto}")
    ProdutoResponse buscaProdutoPorId(@PathVariable(name = "idProduto") Long idProduto);

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    List<ProdutoListResponse> listaDeProdutos();

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping(params = "codigo")
    ProdutoResponse buscaProdutoPorCodigo(@PathParam("codigo") String codigo);

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @DeleteMapping("/{idProduto}")
    void deletaProdutoPorId(@PathVariable(name = "idProduto") Long idProduto);

    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    @PatchMapping("/{idProduto}")
    void autualizaProdutoPorId(@PathVariable(name = "idProduto") Long idProduto, @RequestBody AtualizaProdutoRequest produtoRequest);

}
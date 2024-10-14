package com.github.joanerson.aws_projecto01.teste.application.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
public interface TesteHomeController {

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/dog/{nome}")
    String getTesteHome(@PathVariable String nome);
}
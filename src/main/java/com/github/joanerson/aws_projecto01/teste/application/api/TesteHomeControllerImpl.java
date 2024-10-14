package com.github.joanerson.aws_projecto01.teste.application.api;

import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class TesteHomeControllerImpl implements TesteHomeController {

    @Override
    public String getTesteHome(String nome) {
        log.info("[start] TesteHomeControllerImpl - getTesteHome");
        log.info("[nome] {}", nome);
        return nome;
    }
}
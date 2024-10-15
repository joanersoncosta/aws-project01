package com.github.joanerson.aws_projecto01.teste.application.api;

import com.github.joanerson.aws_projecto01.teste.application.api.request.CreateDogRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
@RequiredArgsConstructor
public class TesteHomeControllerImpl implements TesteHomeController {
   private final CreateDogRequest createDogRequest;

    @Override
    public CreateDogRequest createDog(CreateDogRequest createDogRequest) {
        log.info("[start] TesteHomeControllerImpl - createDog");
        log.info("[createDogRequest] {}", createDogRequest);
        return createDogRequest;
    }

    @Override
    public String getTesteHome(String nome) {
        log.info("[start] TesteHomeControllerImpl - getTesteHome");
        log.info("[nome] {}", nome);
        return nome;
    }


}
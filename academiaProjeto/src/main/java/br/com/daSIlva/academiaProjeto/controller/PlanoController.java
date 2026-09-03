package br.com.daSIlva.academiaProjeto.controller;

import br.com.daSIlva.academiaProjeto.database.model.PlanoEntity;
import br.com.daSIlva.academiaProjeto.database.repository.PlanoRepository;
import br.com.daSIlva.academiaProjeto.dto.request.PlanoRequestDto;
import br.com.daSIlva.academiaProjeto.service.PlanoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/v1/plano")
public class PlanoController {
    private final PlanoService planoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarPlano(@RequestBody PlanoRequestDto dto) {
        planoService.criarPlano(dto);
    }
}

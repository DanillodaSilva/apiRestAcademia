package br.com.daSIlva.academiaProjeto.controller;

import br.com.daSIlva.academiaProjeto.dto.request.MatriculaRequestDto;
import br.com.daSIlva.academiaProjeto.service.MatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1/matricula")
@Validated
public class MatriculaController {
    private final MatriculaService matriculaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarMatricula(@Valid @RequestBody MatriculaRequestDto dto){
        matriculaService.criarMatricula(dto);
    }

}

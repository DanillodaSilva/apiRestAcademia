package br.com.daSIlva.academiaProjeto.controller;

import br.com.daSIlva.academiaProjeto.dto.request.MatriculaRequestDto;
import br.com.daSIlva.academiaProjeto.dto.response.MatriculaResponseDto;
import br.com.daSIlva.academiaProjeto.service.MatriculaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MatriculaResponseDto> findAllMatricula(){
        return matriculaService.findAllMatricula();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MatriculaResponseDto findByIdMatricula(@Valid @PathVariable UUID id){
        return matriculaService.findById(id);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@Valid @PathVariable UUID id){
        matriculaService.deleteById(id);
    }
}

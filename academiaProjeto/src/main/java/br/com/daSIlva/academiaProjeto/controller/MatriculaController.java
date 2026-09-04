package br.com.daSIlva.academiaProjeto.controller;

import br.com.daSIlva.academiaProjeto.dto.request.MatriculaRequestDto;
import br.com.daSIlva.academiaProjeto.dto.response.MatriculaResponseDto;
import br.com.daSIlva.academiaProjeto.service.MatriculaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Matricula", description = "Gerenciamento das matriculas da academia")
public class MatriculaController {
    private final MatriculaService matriculaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Criar matricula",
            description = "Cria uma nova matricula no sistema"
    )
    public void criarMatricula(@Valid @RequestBody MatriculaRequestDto dto){
        matriculaService.criarMatricula(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Lista matricula",
            description = "Retorna todos as matriculas cadastrados no sistema"
    )
    public List<MatriculaResponseDto> findAllMatricula(){
        return matriculaService.findAllMatricula();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Busca matricula pelo id",
            description = "Retorna a matricula que tenha o id passado"
    )
    public MatriculaResponseDto findByIdMatricula(@Valid @PathVariable UUID id){
        return matriculaService.findById(id);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Deleta matricula",
            description = "Deleta a matricula pelo seu id"
    )
    public void deleteById(@Valid @PathVariable UUID id){
        matriculaService.deleteById(id);
    }
}

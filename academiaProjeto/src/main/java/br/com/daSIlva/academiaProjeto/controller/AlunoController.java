package br.com.daSIlva.academiaProjeto.controller;

import br.com.daSIlva.academiaProjeto.dto.request.AlunoRequestDto;
import br.com.daSIlva.academiaProjeto.dto.response.AlunoResponseDto;
import br.com.daSIlva.academiaProjeto.exception.BadRequestException;
import br.com.daSIlva.academiaProjeto.exception.NotFoundException;
import br.com.daSIlva.academiaProjeto.service.AlunoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/aluno")
@Validated
@Tag(name = "Alunos", description = "Endpoints responsáveis pelo gerenciamento dos alunos")
public class AlunoController {
    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
   @Operation(
           summary = "Criar aluno",
           description = "Cria um novo aluno no sistema"
   )
    public void criarAluno(@Valid @RequestBody AlunoRequestDto dto) throws BadRequestException {
        alunoService.criarAluno(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Lista alunos",
            description = "Retorna todos os alunos cadastrados no sistema"
    )
    public List<AlunoResponseDto> findAllAluno(){
        return alunoService.findAll();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Busca aluno pelo id",
            description = "Retorna o aluno que tenha o id passado"
    )
    public AlunoResponseDto findBYIdAluno(@Valid @PathVariable UUID id) throws NotFoundException {
        return alunoService.findById(id);
    }
    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Deleta aluno",
            description = "Deleta o aluno pelo seu id"
    )
    public void deleteBYIdAluno(@Valid @PathVariable UUID id) throws NotFoundException {
        alunoService.deleteById(id);
    }
}

package br.com.daSIlva.academiaProjeto.controller;

import br.com.daSIlva.academiaProjeto.dto.request.AlunoRequestDto;
import br.com.daSIlva.academiaProjeto.dto.response.AlunoResponseDto;
import br.com.daSIlva.academiaProjeto.service.AlunoService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/aluno")
@Validated
public class AlunoController {
    private final AlunoService alunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarAluno(@RequestBody AlunoRequestDto dto) throws Exception {
        alunoService.criarAluno(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AlunoResponseDto> findAllAluno(){
        return alunoService.findAll();
    }
}

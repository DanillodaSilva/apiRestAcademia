package br.com.daSIlva.academiaProjeto.controller;

import br.com.daSIlva.academiaProjeto.database.model.PlanoEntity;
import br.com.daSIlva.academiaProjeto.database.repository.PlanoRepository;
import br.com.daSIlva.academiaProjeto.dto.request.PlanoRequestDto;
import br.com.daSIlva.academiaProjeto.dto.response.PlanoResponseDto;
import br.com.daSIlva.academiaProjeto.service.PlanoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;


@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/v1/plano")
@Tag(name = "Planos", description = "Gerenciamento dos planos da academia")
public class PlanoController {
    private final PlanoService planoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(
            summary = "Criar plano",
            description = "Cria um novo plano no sistema"
    )
    public void criarPlano(@Valid @RequestBody PlanoRequestDto dto) {
        planoService.criarPlano(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Lista planos",
            description = "Retorna todos os planos cadastrados no sistema"
    )
    public List<PlanoResponseDto> findAllPlanos(){
        return planoService.findAllPlanos();
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(
            summary = "Busca plano pelo id",
            description = "Retorna o plano que tenha o id passado"
    )
    public PlanoResponseDto findByIdPlanos(@Valid @PathVariable UUID id){
        return planoService.findById(id);
    }

    @DeleteMapping("/id/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(
            summary = "Deleta plano",
            description = "Deleta o plano pelo seu id"
    )
    public void deleteByIdPlanos(@Valid @PathVariable UUID id){
        planoService.deleteById(id);
    }


}

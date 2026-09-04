package br.com.daSIlva.academiaProjeto.dto.response;

import br.com.daSIlva.academiaProjeto.database.model.AlunoEntity;
import br.com.daSIlva.academiaProjeto.database.model.PlanoEntity;
import br.com.daSIlva.academiaProjeto.database.model.StatusDaMaTricula;

import java.time.LocalDate;
import java.util.UUID;

public record MatriculaResponseDto(UUID id,
                                   LocalDate diaDaMatricula,
                                   StatusDaMaTricula statusDaMaTricula,
                                   AlunoResponseDto aluno,
                                   PlanoResponseDto plano) {
}

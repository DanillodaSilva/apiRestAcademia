package br.com.daSIlva.academiaProjeto.dto.request;

import br.com.daSIlva.academiaProjeto.database.model.AlunoEntity;
import br.com.daSIlva.academiaProjeto.database.model.PlanoEntity;
import br.com.daSIlva.academiaProjeto.database.model.StatusDaMaTricula;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatriculaRequestDto {
    @NotNull
    @Past
    LocalDate diaDaMatricula;
    @NotNull
    StatusDaMaTricula statusDaMaTricula;
    @NotNull
    AlunoEntity aluno;
    @NotNull
    PlanoEntity plano;
}

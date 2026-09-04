package br.com.daSIlva.academiaProjeto.dto.request;

import br.com.daSIlva.academiaProjeto.database.model.AlunoEntity;
import br.com.daSIlva.academiaProjeto.database.model.PlanoEntity;
import br.com.daSIlva.academiaProjeto.database.model.StatusDaMaTricula;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatriculaRequestDto {
    @NotNull
    @PastOrPresent
    LocalDate diaDaMatricula ;
    @NotNull
    StatusDaMaTricula status;
    @NotNull
    UUID alunoId;
    @NotNull
    UUID planoId;
}

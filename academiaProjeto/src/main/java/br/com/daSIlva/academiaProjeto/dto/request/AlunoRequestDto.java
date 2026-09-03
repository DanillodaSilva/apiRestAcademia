package br.com.daSIlva.academiaProjeto.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AlunoRequestDto {
    @NotBlank
    String nome;
    @NotBlank
    String email;
}

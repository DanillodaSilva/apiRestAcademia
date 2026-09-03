package br.com.daSIlva.academiaProjeto.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanoRequestDto {
    @NotBlank
    String nome;
    @NotNull
    BigDecimal valor;
}

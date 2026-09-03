package br.com.daSIlva.academiaProjeto.dto.response;

import java.math.BigDecimal;
import java.util.UUID;

public record PlanoResponseDto(String nome,
                               BigDecimal preco,
                               UUID id) {
}

package br.com.daSIlva.academiaProjeto.dto.response;

import java.util.UUID;

public record AlunoResponseDto(String nome,
                               String email,
                               UUID id) {
}

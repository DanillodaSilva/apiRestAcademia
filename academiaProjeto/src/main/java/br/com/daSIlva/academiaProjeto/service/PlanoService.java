package br.com.daSIlva.academiaProjeto.service;

import br.com.daSIlva.academiaProjeto.database.repository.PlanoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanoService {
    private final PlanoRepository plano;


}

package br.com.daSIlva.academiaProjeto.service;

import br.com.daSIlva.academiaProjeto.database.model.PlanoEntity;
import br.com.daSIlva.academiaProjeto.database.repository.PlanoRepository;
import br.com.daSIlva.academiaProjeto.dto.request.PlanoRequestDto;
import br.com.daSIlva.academiaProjeto.exception.BadRequestException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlanoService {
    private final PlanoRepository plano;

    public void criarPlano(PlanoRequestDto dto) throws BadRequestException{
        PlanoEntity planoEntity = plano.findByNome(dto.getNome()).orElse(null);
        if(planoEntity != null){
            throw  new BadRequestException("Nome de plano já cadastrado");
        }
        planoEntity = PlanoEntity.builder()
                .nome(dto.getNome())
                .preco(dto.getPreco())
                .build();
        plano.save(planoEntity);
    }

}

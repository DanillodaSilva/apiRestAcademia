package br.com.daSIlva.academiaProjeto.service;

import br.com.daSIlva.academiaProjeto.database.model.PlanoEntity;
import br.com.daSIlva.academiaProjeto.database.repository.PlanoRepository;
import br.com.daSIlva.academiaProjeto.dto.request.PlanoRequestDto;
import br.com.daSIlva.academiaProjeto.dto.response.PlanoResponseDto;
import br.com.daSIlva.academiaProjeto.exception.BadRequestException;
import br.com.daSIlva.academiaProjeto.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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

    public List<PlanoResponseDto> findAllPlanos(){
        List<PlanoEntity> planoEntities = plano.findAll();

        return planoEntities.stream()
                .map(p-> new  PlanoResponseDto(
                        p.getNome(),
                        p.getPreco(),
                        p.getId()
                )).collect(Collectors.toList());
    }

    public PlanoResponseDto findById(UUID id){
        PlanoEntity planoEntity = plano
                .findById(id)
                .orElseThrow(()-> new NotFoundException("Plano não encontrado no sistema"));

        return new PlanoResponseDto(
                planoEntity.getNome(),
                planoEntity.getPreco(),
                planoEntity.getId()
        );
    }

    public void deleteById(UUID id){
        plano.findById(id).orElseThrow(()-> new NotFoundException("Plano não encontrado"));
        plano.deleteById(id);
    }

}

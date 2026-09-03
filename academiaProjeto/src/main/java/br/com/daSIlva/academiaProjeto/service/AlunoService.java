package br.com.daSIlva.academiaProjeto.service;

import br.com.daSIlva.academiaProjeto.database.model.AlunoEntity;
import br.com.daSIlva.academiaProjeto.database.repository.AlunoRepository;
import br.com.daSIlva.academiaProjeto.dto.request.AlunoRequestDto;
import br.com.daSIlva.academiaProjeto.dto.response.AlunoResponseDto;
import br.com.daSIlva.academiaProjeto.exception.BadRequestException;
import br.com.daSIlva.academiaProjeto.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

//    CADASTRAR
    public void criarAluno(AlunoRequestDto dto) throws BadRequestException {
        AlunoEntity aluno = alunoRepository.findByEmail(dto.getEmail()).orElse(null);
        if (aluno != null){
            throw new BadRequestException("Email ja cadastrado");
        }

        aluno = AlunoEntity.builder()
                .email(dto.getEmail())
                .nome(dto.getNome())
                .build();
        alunoRepository.save(aluno);
    }
//    LISTAR
    public List<AlunoResponseDto> findAll(){
        List<AlunoEntity> alunoEntities = alunoRepository.findAll();

        return alunoEntities.stream().map(a -> new AlunoResponseDto(
                a.getNome(),
                a.getEmail(),
                a.getId()
        )).collect(Collectors.toList());
    }
//    BUSCARPORID
    public AlunoResponseDto findById(UUID id) throws NotFoundException {
        AlunoEntity aluno = alunoRepository
                .findById(id)
                .orElseThrow(()->new NotFoundException("Aluno não cadastrado"));

        return new AlunoResponseDto(
                aluno.getNome(),
                aluno.getEmail(),
                aluno.getId()
        );
    }
//    REMOVER
    public void deleteById(UUID id)throws NotFoundException{
        alunoRepository
                .findById(id)
                .orElseThrow(()->new NotFoundException("Aluno não cadastrado"));

        alunoRepository.deleteById(id);
    }
}

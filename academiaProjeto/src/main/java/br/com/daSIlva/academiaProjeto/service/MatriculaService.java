package br.com.daSIlva.academiaProjeto.service;

import br.com.daSIlva.academiaProjeto.database.model.AlunoEntity;
import br.com.daSIlva.academiaProjeto.database.model.MatriculaEntity;
import br.com.daSIlva.academiaProjeto.database.model.PlanoEntity;
import br.com.daSIlva.academiaProjeto.database.repository.AlunoRepository;
import br.com.daSIlva.academiaProjeto.database.repository.MatriculaRepository;
import br.com.daSIlva.academiaProjeto.database.repository.PlanoRepository;
import br.com.daSIlva.academiaProjeto.dto.request.MatriculaRequestDto;
import br.com.daSIlva.academiaProjeto.dto.response.AlunoResponseDto;
import br.com.daSIlva.academiaProjeto.dto.response.MatriculaResponseDto;
import br.com.daSIlva.academiaProjeto.dto.response.PlanoResponseDto;
import br.com.daSIlva.academiaProjeto.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatriculaService {
    private final MatriculaRepository matriculaRepository;
    private final AlunoRepository alunoRepository;
    private final PlanoRepository planoRepository;

    public void criarMatricula(MatriculaRequestDto dto) {
        AlunoEntity aluno = alunoRepository
                .findById(dto.getAlunoId())
                .orElseThrow(() -> new NotFoundException("Aluno não encontrado"));

        PlanoEntity plano = planoRepository
                .findById(dto.getPlanoId())
                .orElseThrow(() -> new NotFoundException("Plano não encontrado"));

        MatriculaEntity matricula = MatriculaEntity.builder()
                .aluno(aluno)
                .diaDaMatricula(dto.getDiaDaMatricula())
                .plano(plano)
                .statusDaMatricula(dto.getStatus())
                .build();

        matriculaRepository.save(matricula);
    }

    public List<MatriculaResponseDto> findAllMatricula(){
        List<MatriculaEntity> matriculaEntities = matriculaRepository.findAll();

        return matriculaEntities.stream().map(m -> {AlunoResponseDto alunoResponseDto = new AlunoResponseDto(
                m.getAluno().getNome(),
                m.getAluno().getEmail(),
                m.getAluno().getId()
                );
                    PlanoResponseDto planoResponseDto = new PlanoResponseDto(
                            m.getPlano().getNome(),
                            m.getPlano().getPreco(),
                            m.getPlano().getId()
                    );
                    return new MatriculaResponseDto(
                            m.getId(),
                            m.getDiaDaMatricula(),
                            m.getStatusDaMatricula(),
                            alunoResponseDto,
                            planoResponseDto
                    );
                })
                .toList();
    }

    public MatriculaResponseDto findById(UUID id){
        MatriculaEntity m = matriculaRepository
                .findById(id)
                .orElseThrow(()->new NotFoundException("Matricula não encontrada"));
        PlanoResponseDto planoResponseDto = new PlanoResponseDto(
                m.getPlano().getNome(),
                m.getPlano().getPreco(),
                m.getPlano().getId()
        );
        AlunoResponseDto alunoResponseDto = new AlunoResponseDto(
                m.getAluno().getNome(),
                m.getAluno().getEmail(),
                m.getAluno().getId()
        );
        return new MatriculaResponseDto(
                m.getId(),
                m.getDiaDaMatricula(),
                m.getStatusDaMatricula(),
                alunoResponseDto,
                planoResponseDto
        );
    }

}

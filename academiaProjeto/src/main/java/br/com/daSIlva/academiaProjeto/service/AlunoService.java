package br.com.daSIlva.academiaProjeto.service;

import br.com.daSIlva.academiaProjeto.database.model.AlunoEntity;
import br.com.daSIlva.academiaProjeto.database.repository.AlunoRepository;
import br.com.daSIlva.academiaProjeto.dto.request.AlunoRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

//    CADASTRAR
    public void criarAluno(AlunoRequestDto dto) throws Exception {
        AlunoEntity aluno = alunoRepository.findByEmail(dto.getEmail()).orElse(null);
        if (aluno != null){
            throw new Exception("Email ja cadastrado");
        }

        aluno = AlunoEntity.builder()
                .email(dto.getEmail())
                .nome(dto.getNome())
                .build();
        alunoRepository.save(aluno);
    }
//    LISTAR
//    BUSCARPORID
//    REMOVER
}

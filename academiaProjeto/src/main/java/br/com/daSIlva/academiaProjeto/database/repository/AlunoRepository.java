package br.com.daSIlva.academiaProjeto.database.repository;

import br.com.daSIlva.academiaProjeto.database.model.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunoRepository extends JpaRepository<AlunoEntity, UUID> {
}

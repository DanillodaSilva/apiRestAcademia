package br.com.daSIlva.academiaProjeto.database.repository;

import br.com.daSIlva.academiaProjeto.database.model.AlunoEntity;
import br.com.daSIlva.academiaProjeto.database.model.StatusDaMaTricula;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AlunoRepository extends JpaRepository<AlunoEntity, UUID> {
    Optional<AlunoEntity> findByEmail(String email);
}

package br.com.daSIlva.academiaProjeto.database.repository;

import br.com.daSIlva.academiaProjeto.database.model.PlanoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface PlanoRepository extends JpaRepository<PlanoEntity, UUID> {
    Optional<PlanoEntity> findByNome(String nome);
}

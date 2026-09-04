package br.com.daSIlva.academiaProjeto.database.repository;

import br.com.daSIlva.academiaProjeto.database.model.MatriculaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface MatriculaRepository extends JpaRepository<MatriculaEntity, UUID> {
}

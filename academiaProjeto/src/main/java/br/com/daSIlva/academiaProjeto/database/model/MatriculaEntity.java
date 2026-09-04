package br.com.daSIlva.academiaProjeto.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "matricula")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatriculaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private LocalDate diaDaMatricula;
    @Column(nullable = false)
    private StatusDaMaTricula statusDaMaTricula;

    @ManyToOne
    @JoinColumn(name = "aluno_id")
    private AlunoEntity aluno;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private PlanoEntity plano;




}

package br.com.daSIlva.academiaProjeto.database.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "planos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false,unique = true)
    private String nome;
    @Column(nullable = false)
    private BigDecimal preco;
}

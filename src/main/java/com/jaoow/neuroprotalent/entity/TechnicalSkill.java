package com.jaoow.neuroprotalent.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@RequiredArgsConstructor
@Entity // Define esta classe como uma entidade JPA, mapeando-a para uma tabela no banco de dados.
public class TechnicalSkill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String level;

    @ManyToOne( // Define um relacionamento "muitos para um" com a entidade `Employee`.
            fetch = FetchType.LAZY, // Carrega o funcionário associado sob demanda (lazy loading).
            cascade = CascadeType.ALL // Propaga operações (como persistência e remoção) para a entidade associada.
    )
    @JoinColumn(name = "employee_id") // Especifica a coluna de chave estrangeira na tabela `TechnicalSkill` que referencia a tabela `Employee`.
    private Employee employee; // Representa o funcionário ao qual esta habilidade técnica pertence.
}

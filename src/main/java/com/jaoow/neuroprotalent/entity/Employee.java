package com.jaoow.neuroprotalent.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity // Indica que esta classe é uma entidade JPA, mapeando-a para uma tabela no banco de dados.
public class Employee {

    @Id // Define o atributo `id` como a chave primária da entidade.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // Especifica que o valor do ID será gerado automaticamente pelo banco de dados.
    // A estratégia `IDENTITY` usa uma coluna auto-increment no banco.
    private Long id;

    private String name;
    private String email;
    private String phone;
    private int experienceTime;
    private String linkedInUrl;

    @OneToMany( // Define um relacionamento "um para muitos" entre `Employee` e outra entidade.
            fetch = FetchType.LAZY, // Especifica que os dados das certificações serão carregados sob demanda (lazy loading).
            cascade = CascadeType.ALL, // Propaga todas as operações (como persistência, remoção, etc.) para as certificações associadas.
            mappedBy = "employee" // Indica que a propriedade `employee` na classe `Certification` é a proprietária da relação.
    )
    private List<Certification> certifications; // Lista de certificações associadas ao funcionário.

    @OneToMany( // Define outro relacionamento "um para muitos" entre `Employee` e `TechnicalSkill`.
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL,
            mappedBy = "employee" // Indica que a propriedade `employee` na classe `TechnicalSkill` é a proprietária da relação.
    )
    private List<TechnicalSkill> technicalSkills; // Lista de habilidades técnicas associadas ao funcionário.

}

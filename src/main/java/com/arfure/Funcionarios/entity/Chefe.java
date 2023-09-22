package com.arfure.Funcionarios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;
@Entity
@Table(name = "TB_CHEFE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Chefe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CHE_ID")
    private Long id;

    @Column(name = "CHE_NOME")
    private String nome;

    @OneToMany(mappedBy = "chefe", fetch = FetchType.LAZY)
    private Set<Empregado> empregados;
}

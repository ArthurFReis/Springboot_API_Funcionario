package com.arfure.Funcionarios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@Table(name = "TB_EMP")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Empregado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMP_ID")
    private Long id;

    @Column(name = "EMP_NOME")
    private String nome;

    @Transient
    private boolean ocupado;

    @Embedded
    private Endereco endereco;

    @OneToOne(cascade = CascadeType.ALL )
    @JoinColumn(name = "CAR_ID")
    private Cargo cargo;

    @ManyToOne
    @JoinColumn(name = "CHE_ID")
    private Chefe chefe;

    @ManyToMany(mappedBy = "empregados")
    private List<Tarefa> tarefas;

}

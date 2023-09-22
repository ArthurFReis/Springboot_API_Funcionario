package com.arfure.Funcionarios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.*;

@Entity
@Table(name = "TB_TAREFA")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TAR_ID")
    private Long id;

    @Column(name = "TAR_DESCRICAO")
    private String descricao;

    @ManyToMany
    @JoinTable(name = "TB_EMP_TAR",
    joinColumns = @JoinColumn(name = "TAR_ID"),
    inverseJoinColumns = @JoinColumn(name = "EMP_ID"))
    private List<Empregado> empregados;
}

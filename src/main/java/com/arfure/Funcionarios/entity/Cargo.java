package com.arfure.Funcionarios.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "TB_CARGO")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CAR_ID")
    private Long id;

    @Column(name = "CAR_NOME")
    private String nome;

    @Column(name = "CAR_SALARIO")
    private float salario;

    @OneToOne(mappedBy = "cargo")
    private Empregado empregado;

}

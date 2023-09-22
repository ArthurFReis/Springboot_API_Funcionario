package com.arfure.Funcionarios.entity;

import jakarta.persistence.*;

@Embeddable
public class Endereco {

    @Column(name = "EMP_RUA")
    private String rua;
    @Column(name = "EMP_NUMERO")
    private int numero;
    @Column(name = "EMP_COMPLEMENTO")
    private String complemento;
    @Column(name = "EMP_CEP")
    private String cep;
}

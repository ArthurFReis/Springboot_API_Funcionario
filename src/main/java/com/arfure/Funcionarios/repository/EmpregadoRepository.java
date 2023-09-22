package com.arfure.Funcionarios.repository;

import com.arfure.Funcionarios.entity.Empregado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmpregadoRepository extends JpaRepository<Empregado, Long> {
}

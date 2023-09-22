package com.arfure.Funcionarios.repository;

import com.arfure.Funcionarios.entity.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
}
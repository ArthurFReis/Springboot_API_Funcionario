package com.arfure.Funcionarios.repository;

import com.arfure.Funcionarios.entity.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CargoRepository extends JpaRepository<Cargo, Long> {
}
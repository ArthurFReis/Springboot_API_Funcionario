package com.arfure.Funcionarios.service;

import com.arfure.Funcionarios.repository.CargoRepository;
import com.arfure.Funcionarios.repository.ChefeRepository;
import com.arfure.Funcionarios.repository.EmpregadoRepository;
import com.arfure.Funcionarios.entity.Empregado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class EmpregadoService {

    @Autowired
    private EmpregadoRepository empregadoRepository;

    @Autowired
    private CargoRepository cargoRepository;

    @Autowired
    private ChefeRepository chefeRepository;

    public Empregado salvar(Empregado empregado){

        this.cargoRepository.save(empregado.getCargo());
        this.chefeRepository.save(empregado.getChefe());
        return empregadoRepository.save(empregado);
    }

    public List<Empregado> listaEmpregado(){
        return empregadoRepository.findAll();
    }

    public Optional<Empregado> buscarPorId(Long id){
        return empregadoRepository.findById(id);
    }

    public void removerPorId(Long id){
        empregadoRepository.deleteById(id);
    }


}

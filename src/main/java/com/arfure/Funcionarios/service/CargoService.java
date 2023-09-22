package com.arfure.Funcionarios.service;

import com.arfure.Funcionarios.entity.Cargo;
import com.arfure.Funcionarios.repository.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public Cargo salvar(Cargo cargo){

        return cargoRepository.save(cargo);
    }

    public List<Cargo> listaCargo(){
        return cargoRepository.findAll();
    }

    public Optional<Cargo> buscarPorId(Long id){
        return cargoRepository.findById(id);
    }

    public void removerPorId(Long id){
        cargoRepository.deleteById(id);
    }

}

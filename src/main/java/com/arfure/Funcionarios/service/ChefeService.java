package com.arfure.Funcionarios.service;

import com.arfure.Funcionarios.entity.Chefe;
import com.arfure.Funcionarios.repository.ChefeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class ChefeService {

    @Autowired
    private ChefeRepository chefeRepository;

    public Chefe salvar(Chefe chefe){

        return chefeRepository.save(chefe);
    }

    public List<Chefe> listaChefe(){
        return chefeRepository.findAll();
    }

    public Optional<Chefe> buscarPorId(Long id){
        return chefeRepository.findById(id);
    }

    public void removerPorId(Long id){
        chefeRepository.deleteById(id);
    }
}

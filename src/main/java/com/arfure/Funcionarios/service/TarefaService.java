package com.arfure.Funcionarios.service;

import com.arfure.Funcionarios.entity.Tarefa;
import com.arfure.Funcionarios.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public Tarefa salvar(Tarefa tarefa){

        return tarefaRepository.save(tarefa);
    }

    public List<Tarefa> listaTarefa(){
        return tarefaRepository.findAll();
    }

    public Optional<Tarefa> buscarPorId(Long id){
        return tarefaRepository.findById(id);
    }

    public void removerPorId(Long id){
        tarefaRepository.deleteById(id);
    }
}

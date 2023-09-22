package com.arfure.Funcionarios.controller;


import com.arfure.Funcionarios.entity.Tarefa;
import com.arfure.Funcionarios.service.TarefaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/tarefa")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa salvar(@RequestBody Tarefa tarefa){
        return tarefaService.salvar(tarefa);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Tarefa> listaTarefa(){
        return tarefaService.listaTarefa();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Tarefa buscarTarefaPorId(@PathVariable("id") Long id){
        return tarefaService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa nao encontrado"));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerTarefa(@PathVariable("id") Long id){
        tarefaService.buscarPorId(id)
                .map(tarefa -> {
                    tarefaService.removerPorId(tarefa.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarTarefa(@PathVariable("id") Long id,  @RequestBody Tarefa tarefa){
        tarefaService.buscarPorId(id)
                .map(tarefaBase -> {
                    modelMapper.map(tarefa, tarefaBase);
                    tarefaService.salvar(tarefaBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tarefa nao encontrado"));
    }
}

package com.arfure.Funcionarios.controller;

import com.arfure.Funcionarios.entity.Chefe;
import com.arfure.Funcionarios.service.ChefeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/chefe")
public class ChefeController {

    @Autowired
    private ChefeService chefeService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Chefe salvar(@RequestBody Chefe chefe){
        return chefeService.salvar(chefe);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Chefe> listaChefe(){
        return chefeService.listaChefe();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Chefe buscarChefePorId(@PathVariable("id") Long id){
        return chefeService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chefe nao encontrado"));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEmpregado(@PathVariable("id") Long id){
       chefeService.buscarPorId(id)
                .map(empregado -> {
                    chefeService.removerPorId(empregado.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chefe nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarChefe(@PathVariable("id") Long id,  @RequestBody Chefe chefe){
        chefeService.buscarPorId(id)
                .map(chefeBase -> {
                    modelMapper.map(chefe, chefeBase);
                    chefeService.salvar(chefeBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Chefe nao encontrado"));
    }
}

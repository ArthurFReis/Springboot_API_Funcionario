package com.arfure.Funcionarios.controller;

import com.arfure.Funcionarios.entity.Empregado;
import com.arfure.Funcionarios.service.EmpregadoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/empregado")
public class EmpregadoController {
    @Autowired
    private EmpregadoService empregadoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Empregado salvar(@RequestBody Empregado empregado){
        return empregadoService.salvar(empregado);
    }

//    @PostMapping("/{idCargo}/{idChfe}")
//    public Empregado salvar(@RequestBody Empregado empregado, @PathVariable("idCargo") Long idCargo, @PathVariable("idChefe") Long idChefe) {
//        return empregado
//    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Empregado> listaEmpregado(){
        return empregadoService.listaEmpregado();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Empregado buscarEmpregadoPorId(@PathVariable("id") Long id){
        return empregadoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregado nao encontrado"));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerEmpregado(@PathVariable("id") Long id){
        empregadoService.buscarPorId(id)
                .map(empregado -> {
                    empregadoService.removerPorId(empregado.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregado nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarEmpregado(@PathVariable("id") Long id,  @RequestBody Empregado empregado){
        empregadoService.buscarPorId(id)
                .map(empregadoBase -> {
                    modelMapper.map(empregado, empregadoBase);
                    empregadoService.salvar(empregadoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Empregado nao encontrado"));
    }
}

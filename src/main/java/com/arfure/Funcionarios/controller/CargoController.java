package com.arfure.Funcionarios.controller;

import com.arfure.Funcionarios.entity.Cargo;
import com.arfure.Funcionarios.service.CargoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/cargo")
public class CargoController {

    @Autowired
    private CargoService cargoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cargo salvar(@RequestBody Cargo cargo){
        return cargoService.salvar(cargo);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cargo> listaCargo(){
        return cargoService.listaCargo();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Cargo buscarCargoPorId(@PathVariable("id") Long id){
        return cargoService.buscarPorId(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo nao encontrado"));
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void removerCargo(@PathVariable("id") Long id){
        cargoService.buscarPorId(id)
                .map(cargo -> {
                    cargoService.removerPorId(cargo.getId());
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo nao encontrado"));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarCargo(@PathVariable("id") Long id,  @RequestBody Cargo cargo){
        cargoService.buscarPorId(id)
                .map(cargoBase -> {
                    modelMapper.map(cargo, cargoBase);
                    cargoService.salvar(cargoBase);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cargo nao encontrado"));
    }
}

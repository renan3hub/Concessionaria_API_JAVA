package com.br.concessionaria.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.concessionaria.model.Carro;
import com.br.concessionaria.service.CarroService;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController
@RequestMapping("/carros")
public class CarroController {
    private final CarroService service;

    public CarroController(CarroService service) {
        this.service = service;
    }

    @GetMapping
    public List<Carro> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Carro cadastrar(@RequestBody Carro carro) {
        return service.salvar(carro);
    }
    
    @PutMapping("/{id}")
    public Carro atualizar(@PathVariable Long id, @RequestBody Carro carroAtualizado) {
        Carro carro = service.buscarPorId(id);

    carro.setMarca(carroAtualizado.getMarca());
    carro.setModelo(carroAtualizado.getModelo());
    carro.setAno(carroAtualizado.getAno());
    carro.setPreco(carroAtualizado.getPreco());

    return service.salvar(carro);

    }
    @DeleteMapping("/{id}")
public String deletar(@PathVariable Long id) {

    Carro carro = service.buscarPorId(id);

    service.deletar(carro.getId());

    return "Carro removido com sucesso!";
}
    
}

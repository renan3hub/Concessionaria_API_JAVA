package com.br.concessionaria.service;

import com.br.concessionaria.model.Carro;
import com.br.concessionaria.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarroService {
    private final CarroRepository repository;

    public CarroService(CarroRepository repository) {
        this.repository = repository;
    }

    public List<Carro> listarTodos() {
        return repository.findAll();
    }

    public Carro salvar(Carro carro) {
        return repository.save(carro);
    }

    public Carro buscarPorId(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Carro não encontrado"));
    }
    public void deletar(Long id) {
    repository.deleteById(id);
    }

}

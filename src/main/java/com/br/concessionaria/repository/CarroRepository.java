package com.br.concessionaria.repository;

import com.br.concessionaria.model.Carro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarroRepository extends JpaRepository<Carro, Long> {
    
}
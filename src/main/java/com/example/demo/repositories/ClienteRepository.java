package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Cidade;
import com.example.demo.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	List<Cliente> findAllByCidadeNome(String nome);
	
	List<Cliente> findAllByNomeContainingOrCidadeNomeContaining(String nome, String cidadeNome);
	
}

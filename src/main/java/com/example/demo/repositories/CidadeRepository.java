package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

	public Cidade findByUf(String uf);
	
	public List<Cidade> findAllByNomeContainingOrUfContaining(String nome, String uf);
	
}

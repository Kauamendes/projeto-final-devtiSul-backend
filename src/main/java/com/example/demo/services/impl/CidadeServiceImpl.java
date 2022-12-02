package com.example.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cidade;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.services.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {

	@Autowired
	private CidadeRepository repo;
	
	@Override
	public Cidade salvar(Cidade cidade) {
		return repo.save(cidade);
	}
	
	@Override
	public Cidade alterar(Cidade cidade) {
		return repo.save(cidade);
	}

	@Override
	public List<Cidade> listarTodas() {
		return repo.findAll();
	}

	@Override
	public void excluir(Integer id) {
		if(repo.existsById(id)) repo.deleteById(id);
	}
	
	@Override
	public void excluirTodas() {
		repo.deleteAll();
	}

	@Override
	public Cidade buscarPorUf(String uf) {
		return repo.findByUf(uf);
	}

	@Override
	public List<Cidade> buscarPorNomeContaining(String nome) {
		return repo.findAllByNomeContainingOrUfContaining(nome, nome);
	}
}

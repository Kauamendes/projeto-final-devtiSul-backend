package com.example.demo.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Cidade;
import com.example.demo.model.Cliente;
import com.example.demo.repositories.CidadeRepository;
import com.example.demo.repositories.ClienteRepository;
import com.example.demo.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	ClienteRepository repo;

	@Override
	public List<Cliente> listarTodos() {
		return repo.findAll();
	}

	@Override
	@Transactional
	public Cliente salvar(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override
	@Transactional
	public Cliente alterar(Cliente cliente) {
		return repo.save(cliente);
	}

	@Override
	public void excluir(Integer id) {
		if(repo.existsById(id)) repo.deleteById(id);
	}

	@Override
	public List<Cliente> listarPorCidade(String cidade) {
		return repo.findAllByCidadeNome(cidade);
	}

	@Override
	public void excluirTodos() {
		repo.deleteAll();
	}

	@Override
	public List<Cliente> listarPorNomeContaining(String nome) {
		return repo.findAllByNomeContainingOrCidadeNomeContaining(nome, nome);
	}

}

package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Cidade;
import com.example.demo.model.Cliente;

public interface ClienteService {

	List<Cliente> listarTodos();
	
	Cliente salvar(Cliente cliente);
	
	Cliente alterar(Cliente cliente);
	
	void excluir(Integer id);
	
	List<Cliente> listarPorCidade(String cidade);
	
	void excluirTodos();

	List<Cliente> listarPorNomeContaining(String nome);
	
}

package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Cidade;

public interface CidadeService {
	
	Cidade salvar(Cidade cidade);
	
	List<Cidade> listarTodas();
	
	Cidade alterar(Cidade cidade);
	
	void excluir(Integer id);

	void excluirTodas();
	
	Cidade buscarPorUf(String uf);

	List<Cidade> buscarPorNomeContaining(String search);

}

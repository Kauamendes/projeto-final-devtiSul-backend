package com.example.demo.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Cidade;
import com.example.demo.services.CidadeService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cidade")
@RequiredArgsConstructor
public class CidadeResource {

	private final CidadeService service;
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Salva uma cidade")
	public Cidade salvarCidade(@RequestBody Cidade c) {
		return service.salvar(c);
	}
	
	@PutMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Altera uma cidade")
	public Cidade AlterarCidade(@RequestBody Cidade c, @RequestParam("id") int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Lista todas as cidade")
	public List<Cidade> listarTodas() {
		return service.listarTodas();
	}
	
	@GetMapping("buscaruf/{uf}")
	@ApiOperation(value = "Busca cidades por UF")
	public Cidade buscarPorUf(@PathVariable("uf") String uf) {
		return service.buscarPorUf(uf);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma cidade")
	public void excluir(@PathVariable("id") Integer id) {
		service.excluir(id);
	}
	
	@DeleteMapping("/all")
	@ApiOperation(value = "Deleta todas cidade")
	public void excluirTodas() {
		service.excluirTodas();
	}
	
	@GetMapping("/sugest/{nome}")
	@ApiOperation(value = "Lista todas cidade baseado no que e digitado")
	public List<Cidade> buscarCidadePorNomeContaining(@PathVariable("nome") String nome) {
		return service.buscarPorNomeContaining(nome);
	}
	
}

package com.example.demo.resources;

import java.util.List;

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
import com.example.demo.model.Cliente;
import com.example.demo.services.CidadeService;
import com.example.demo.services.ClienteService;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cliente")
@RequiredArgsConstructor
public class ClienteResource {
	
	private final ClienteService service;
	
	@PostMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Salva um cliente")
	public Cliente salvarCidade(@RequestBody Cliente c) {
		return service.salvar(c);
	}
	
	@PutMapping(produces = "application/json", consumes = "application/json")
	@ApiOperation(value = "Altera um cliente")
	public Cliente AlterarCidade(@RequestBody Cliente c, @RequestParam("id") int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@GetMapping(produces = "application/json")
	@ApiOperation(value = "Lista todos os clientes")
	public List<Cliente> listarTodas() {
		return service.listarTodos();
	}
	
	@GetMapping("/{cidadeNome}")
	@ApiOperation(value = "Lista clientes por cidade")
	public List<Cliente> listarPorNomeCidade(@PathVariable("cidadeNome") String cidadeNome) {
		return service.listarPorCidade(cidadeNome);
	}
	
	@GetMapping("sugest/{nome}")
	@ApiOperation(value = "Lista clientes por nome")
	public List<Cliente> listarPorNomeContaining(@PathVariable("nome") String nome) {
		return service.listarPorNomeContaining(nome);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um cliente")
	public void excluir(@PathVariable("id") Integer id) {
		service.excluir(id);
	}
	
	@DeleteMapping("/all")
	@ApiOperation(value = "Deleta todos os cliente")
	public void excluir() {
		service.excluirTodos();
	}

}

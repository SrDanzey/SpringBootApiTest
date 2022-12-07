package com.devti.aula.resources;

import java.util.List;
import java.util.Optional;

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

import com.devti.aula.model.Cidade;
import com.devti.aula.model.Cliente;
import com.devti.aula.services.ClienteService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {

	@Autowired
	ClienteService service;
	
	@GetMapping
	@ApiOperation(value = "Monstra todos os clienes dentro da base de dados")
	public List<Cliente> listarTodos(){
		return service.listaTodos();
	}
	
	@PostMapping
	@ApiOperation(value = "Cria uma novo clienes dentro da base de dados")
	public Cliente incluir(@RequestBody Cliente c) {
		return service.incluir(c);
	}
	
	@PutMapping
	@ApiOperation(value = "Altera um clienes dentro da base de dados")
	public Cliente alterar(@RequestBody Cliente c, @RequestParam("id") int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta um clienes dentro da base de dados")
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);
	}

	@GetMapping("/buscarcidade/{cidade}")
	@ApiOperation(value = "Busca cliente dentro da base de dados pelo id da cidade")
	public List<Cliente> buscarPorCidade(@PathVariable("cidade") Cidade cidade){
		return service.buscaPorCidade(cidade);
	}

	@RequestMapping("/buscarcidadepornome/{nome}")
	@ApiOperation(value = "Busca cliente dentro da base de dados pelo nome da cidade")
	public List<Cliente> buscarClientePorNomeCidade(@PathVariable(value="nome") String nome){
		return service.buscarClientePorNomeCidade(nome);
	}
	
	@GetMapping("/buscarporid/{id}")
	@ApiOperation(value = "Busca cliente dentro da base de dados pelo id do cliente")
	public Optional<Cliente> buscarClienteId(@PathVariable("id") Integer id){
		return service.buscaClienteId(id);
	}
}

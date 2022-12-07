package com.devti.aula.resources;

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
import com.devti.aula.services.CidadeService;

import io.swagger.annotations.ApiOperation;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {
	
	@Autowired
	CidadeService service;

	@PostMapping
	@ApiOperation(value = "Cria uma nova cidade dentro da base de dados")
	public Cidade inserirCidade(@RequestBody Cidade c) {
		return service.incluir(c);
	}
	
	@GetMapping
	@ApiOperation(value = "Lista todas as cidades dentro da base de dados")
	public  List<Cidade> listarTodas(){
		return service.listarTodas();
	}
	
	@PutMapping
	@ApiOperation(value = "Altera uma das cidades dentro da base de dados")
	public Cidade alterar(@RequestBody Cidade c, @RequestParam("id") int id) {
		c.setId(id);
		return service.alterar(c);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Deleta uma das cidades dentro da base de dados")
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);
	}
	
	@GetMapping("/buscauf/{uf}")
	@ApiOperation(value = "Busca as cidades dentro da base de dados pela uf")
	public List<Cidade> buscarPorUf(@PathVariable("uf") String uf) {
		return service.buscarPorUf(uf);
	}
	
	@GetMapping("/buscacidade/{cidade}")
	@ApiOperation(value = "Busca as cidades dentro da base de dados pelo nome")
	public List<Cidade> buscarPorNome(@PathVariable("cidade") String cidade){
		return service.buscarPorNome(cidade);
	}

}

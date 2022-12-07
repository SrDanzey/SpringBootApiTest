package com.devti.aula.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.aula.model.Cidade;
import com.devti.aula.model.Cliente;
import com.devti.aula.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository rep;

	public List<Cliente> listaTodos(){
		return rep.findAll();
	}
	
	public Cliente incluir(Cliente c) {
		return rep.save(c);
	}
	
	public Cliente alterar(Cliente c) {
		return rep.save(c);
	}
	
	public void excluir(Integer id) {
		Cliente clieteExcluir = rep.findById(id).get();
		if (clieteExcluir != null) {
			rep.delete(clieteExcluir);
		}
	}
	
	public List<Cliente> buscaPorCidade(Cidade cidade){
		return rep.findByCidade(cidade);
	}

	public List<Cliente> buscarClientePorNomeCidade(String nome) {
		return rep.findAllByCidadeNome(nome);
	}
	
	public Optional<Cliente> buscaClienteId(Integer id){
		return rep.findById(id);
	}
}

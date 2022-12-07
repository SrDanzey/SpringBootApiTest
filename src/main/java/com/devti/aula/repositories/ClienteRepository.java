package com.devti.aula.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devti.aula.model.Cidade;
import com.devti.aula.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	List<Cliente> findByCidade(Cidade cidade);
	
	List<Cliente> findAllByCidadeNome(String nome);
	
	public Optional<Cliente> findById(Integer id);
	
}

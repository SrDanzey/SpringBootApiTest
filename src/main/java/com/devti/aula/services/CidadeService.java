package com.devti.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.aula.model.Cidade;
import com.devti.aula.repositories.CidadeRepository;

@Service
public class CidadeService {

	@Autowired
	CidadeRepository rep;
	
	public Cidade incluir(Cidade c) {
		return rep.save(c);
	}
	
	public List<Cidade> listarTodas(){
		return rep.findAll();	
	}
	
	public Cidade alterar(Cidade c) {
		return rep.save(c);
	}
	
	public void excluir(Integer id) {
		Cidade cidadeExcluir = rep.findById(id).get();
		if (cidadeExcluir != null) {
			rep.delete(cidadeExcluir);
		}
	}
	
	public List<Cidade> buscarPorUf(String uf){
		return rep.findByUf(uf);
	}
	
	public List<Cidade> buscarPorNome(String nome){
		return rep.findByNome(nome);
	}
}

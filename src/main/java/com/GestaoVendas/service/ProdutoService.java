package com.GestaoVendas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.GestaoVendas.domain.Produto;
import com.GestaoVendas.repository.ProdutoRepository;


@Service
public class ProdutoService {
	
	@Autowired
	public ProdutoRepository repo;
	
	public Produto buscar(Integer id) {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElse(null);
	}
	public List<Produto> buscarTodos() {
		return repo.findAll();
	}
	
	public Produto inserir(Produto obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Produto atualizar(Produto obj) {
		return repo.save(obj);
	}
	
	public void deletar(Integer id) {
		buscar(id);
		repo.deleteById(id);
		
	}
}

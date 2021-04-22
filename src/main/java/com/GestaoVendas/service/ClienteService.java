package com.GestaoVendas.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestaoVendas.domain.Cliente;
import com.GestaoVendas.repository.ClienteRepository;


@Service
public class ClienteService {
	
	@Autowired
	public ClienteRepository repo;
	
	public Cliente buscar(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public Cliente inserir(Cliente obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public Cliente atualizar(Cliente obj) {
		return repo.save(obj);
	}
	
	public void deletar(Integer id) {
		buscar(id);
		repo.deleteById(id);
		
	}
}

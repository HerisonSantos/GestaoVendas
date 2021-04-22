package com.GestaoVendas.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GestaoVendas.domain.CarroCompras;
import com.GestaoVendas.domain.Cliente;
import com.GestaoVendas.repository.CarroCompraRepository;
import com.GestaoVendas.repository.ClienteRepository;


@Service
public class CarroCompraService {
	
	@Autowired
	public CarroCompraRepository repo;
	
	public CarroCompras buscar(Integer id) {
		Optional<CarroCompras> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
	public CarroCompras inserir(CarroCompras obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	public CarroCompras atualizar(CarroCompras obj) {
		return repo.save(obj);
	}
	
	public void deletar(Integer id) {
		buscar(id);
		repo.deleteById(id);
		
	}
}

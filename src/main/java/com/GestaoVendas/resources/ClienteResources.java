package com.GestaoVendas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.GestaoVendas.domain.CarroCompras;
import com.GestaoVendas.domain.Cliente;
import com.GestaoVendas.service.CarroCompraService;
import com.GestaoVendas.service.ClienteService;


@RestController
@RequestMapping(value = "/clientes")
public class ClienteResources {
	
	@Autowired
	ClienteService service;
	@Autowired
	CarroCompraService carroService;
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.GET)
	public ResponseEntity<?> buscar(@PathVariable Integer id) {
		
		Cliente obj = service.buscar(id);
		return ResponseEntity.ok().body(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> inserir(@RequestBody Cliente obj){
		CarroCompras carro = new CarroCompras() ;
		if(obj.getCarroCompras()==null) {
			obj.setCarroCompras(carroService.inserir(carro));
		}
		obj= service.inserir(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Cliente obj,@PathVariable Integer id){
		obj.setId(id);
		obj= service.atualizar(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}" ,method = RequestMethod.DELETE)
	public ResponseEntity<?> deletar(@PathVariable Integer id) {
		 service.deletar(id);
		return ResponseEntity.noContent().build();
	}
}

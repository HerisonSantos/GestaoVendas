package com.GestaoVendas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GestaoVendas.domain.CarroCompras;

@Repository
public interface CarroCompraRepository extends JpaRepository<CarroCompras, Integer> {

}

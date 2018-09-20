package com.kometsales.prueba.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.kometsales.prueba.api.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{
	
	public Cliente findByIdentificacion(@Param("identificacion") String identificacion);

}

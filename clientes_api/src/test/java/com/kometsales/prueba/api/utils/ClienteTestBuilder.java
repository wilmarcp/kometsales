package com.kometsales.prueba.api.utils;

import com.kometsales.prueba.api.domain.Cliente;

public class ClienteTestBuilder {

	private String nombres;
	private String primerApellido;
	private String segundoApellido;
	private String identificacion;
	private String telefono;
	private String celular;
	private String email;
	private String ciudad;
	private String direccion;
	
	public ClienteTestBuilder() {
		this.nombres = "JUAN";
		this.primerApellido = "ARANGO";
		this.segundoApellido = "PEREZ";
		this.identificacion = "90897867";
		this.telefono = "4444444";
		this.celular = "30188923";
		this.email = "WACP8987@EMAIL.COM";
		this.ciudad = "MANIZALES";
		this.direccion = "AUTOPISTA NORTE";
	}
	
	
	public ClienteTestBuilder conNombres(String nombres) {
		this.nombres = nombres;
		return this;
	}

	public ClienteTestBuilder conPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
		return this;
	}

	public ClienteTestBuilder conSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
		return this;
	}

	public ClienteTestBuilder conTelefono(String telefono) {
		this.telefono = telefono;
		return this;
	}

	public ClienteTestBuilder conCelular(String celular) {
		this.celular = celular;
		return this;
	}

	public ClienteTestBuilder conEmail(String email) {
		this.email = email;
		return this;
	}

	public ClienteTestBuilder conCiudad(String ciudad) {
		this.ciudad = ciudad;
		return this;
	}

	public ClienteTestBuilder conDireccion(String direccion) {
		this.direccion = direccion;
		return this;
	}

	public ClienteTestBuilder conIdentificacion(String identificacion) {
		this.identificacion = identificacion;
		return this;
	}
	
	
	public Cliente getCliente() {
		Cliente cliente = new Cliente();
		cliente.setCelular(this.celular);
		cliente.setCiudad(ciudad);
		cliente.setDireccion(direccion);
		cliente.setEmail(email);
		cliente.setIdentificacion(identificacion);
		cliente.setNombres(nombres);
		cliente.setPrimerApellido(primerApellido);
		cliente.setSegundoApellido(segundoApellido);
		cliente.setTelefono(telefono);
		return cliente;
	}
}

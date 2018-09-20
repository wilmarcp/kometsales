package com.kometsales.prueba.api.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Table(name = "clientes")
public class Cliente {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "NM_ID", nullable = false, updatable = false, unique = true)
	private Integer id;
	
	@NotEmpty (message = "El nombre del cliente es obligatorio")
	@Size (max = 200, message = "El tamaño máximo para el nombre del cliente es de {max} caracteres")
	@Column (name = "DS_NOMBRES", length = 200, nullable = false)
	private String nombres;

	@NotEmpty (message = "El primer apellido del cliente es obligatorio")
	@Size (max = 200, message = "El tamaño máximo para el primer apellido del cliente es de {max} caracteres")
	@Column (name = "DS_PRIMER_APELLIDO", length = 200, nullable = false)
	private String primerApellido;

	@Size (max = 200, message = "El tamaño máximo para el segundo nombre del cliente es de {max} caracteres")
	@Column (name = "DS_SEGUNDO_APELLIDO", length = 200, nullable = true)
	private String segundoApellido;
	
	@NotNull (message = "La identificación del cliente es obligatoria")
	@Size (max = 35, message = "El tamaño máximo para la identificación del cliente es de {max} caracteres")
	@Pattern (regexp = "^[0-9]+$", message = "La identificación del cliente tiene un formato inválido")
	@Column (name = "DS_IDENTIFICACION", length = 35, nullable = false)
	private String identificacion;

	@Column (name = "DS_TELEFONO", length = 20, nullable = true)
	private String telefono;
	
	@NotNull (message = "El celular del cliente es obligatorio")
	@Size (max = 20, message = "El tamaño máximo para el celular del cliente es de {max} caracteres")
	@Column (name = "DS_CELULAR", length = 20, nullable = false)
	private String celular;
	
	@Email (message = "No es una dirección de email válida")
	@Size (max = 255, message = "El tamaño máximo para el email es de {max} caracteres")
	@Column (name = "DS_EMAIL", length = 255, nullable = true)
	private String email;

	@NotNull (message = "La ciudad del cliente es obligatoria")
	@Column(name="DS_CIUDAD", length=20, nullable = false)
	private String ciudad;

	@NotEmpty (message = "La dirección del cliente es obligatoria")
	@Size (max = 255, message = "El tamaño máximo para la dirección del cliente es de {max} caracteres")
	@Pattern (regexp = "^[ÁÀÄÂáàäâÉÈËÊéèëêÍÌÏÎíìïîÓÒÖÔóòöôÚÙÜÛúùüûÑñ&a-zA-Z0-9 :@¡!,+/“”’'`´¨·#ª°º_<>—–\\\\?\\\\t\\\\\\\\\\\\(\\\\)\\\\\\\"\\\\*\\\\.\\\\-\\\\[\\\\]\\\\x{A0}\\\\x{1F}]*$", message = "La dirección del cliente contiene caracteres inválidos")
	@Column (name = "DS_DIRECCION", length = 255, nullable = false)
	private String direccion;

	@CreationTimestamp
	@Column (name = "FE_CREACION", nullable = false)
	private LocalDateTime fechaCreacion;

	@UpdateTimestamp
	@Column (name = "FE_MODIFICACION", nullable = false)
	private LocalDateTime fechaUltimaModificacion;

	

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public void setFechaCreacion(LocalDateTime fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public LocalDateTime getFechaUltimaModificacion() {
		return fechaUltimaModificacion;
	}

	public void setFechaUltimaModificacion(LocalDateTime fechaUltimaModificacion) {
		this.fechaUltimaModificacion = fechaUltimaModificacion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getIdentificacion() {
		return identificacion;
	}

	public void setIdentificacion(String identificacion) {
		this.identificacion = identificacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String primerApellido) {
		this.primerApellido = primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String segundoApellido) {
		this.segundoApellido = segundoApellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}

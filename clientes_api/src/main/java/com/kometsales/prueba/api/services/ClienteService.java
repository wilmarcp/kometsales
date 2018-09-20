package com.kometsales.prueba.api.services;

import java.util.List;

import org.hibernate.JDBCException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.kometsales.prueba.api.domain.Cliente;
import com.kometsales.prueba.api.exceptions.ServiceException;
import com.kometsales.prueba.api.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente guardarCliente(Cliente cliente) throws ServiceException {
		try {
			clienteRepository.save(cliente);
			return cliente;
		}catch(JDBCException e) {
			throw new ServiceException(ServiceException.ERROR_BD, e);
		}catch(DataIntegrityViolationException e) {
			throw new ServiceException(ServiceException.CLIENTE_YA_REGISTRADO, e);
		}
	}
	
	public Cliente actualizar(Cliente cliente) throws ServiceException {
		try {
			Cliente clienteConsultado = clienteRepository.findById(cliente.getId()).get();
			cliente.setFechaCreacion(clienteConsultado.getFechaCreacion());
			return guardarCliente(cliente);
		}catch(JDBCException e) {
			throw new ServiceException(ServiceException.ERROR_BD, e);
		}catch(DataIntegrityViolationException e) {
			throw new ServiceException(ServiceException.CLIENTE_YA_REGISTRADO, e);
		}
	}

	public Cliente buscarPorIdentificacion(String identificacion)  throws ServiceException {
		try {
			return clienteRepository.findByIdentificacion(identificacion);
		}catch(JDBCException e) {
			throw new ServiceException(ServiceException.ERROR_BD, e);
		}
	}
	
	public List<Cliente> obtenerClientes() throws ServiceException {
		try {
			return clienteRepository.findAll();
		}catch(JDBCException e) {
			throw new ServiceException(ServiceException.ERROR_BD, e);
		}
	}
	
	public void eliminarPorId(Integer id) throws ServiceException {
		try {
			clienteRepository.deleteById(id);
		}catch(JDBCException e) {
			throw new ServiceException(ServiceException.ERROR_BD, e);
		}
	}

}

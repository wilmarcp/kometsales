package com.kometsales.prueba.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.kometsales.prueba.api.domain.Cliente;
import com.kometsales.prueba.api.exceptions.ServiceException;
import com.kometsales.prueba.api.repository.ClienteRepository;
import com.kometsales.prueba.api.services.ClienteService;
import com.kometsales.prueba.api.utils.ClienteTestBuilder;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ClientesApiApplicationTests {

	@Autowired
	ClienteService clienteService;
	
	@Autowired
	ClienteRepository clienteRepository;
	
	@Test
	public void insertarClienteOk() throws ServiceException {
		Cliente almacenado = new Cliente();
		try {
			ClienteTestBuilder clienteBuilder = new ClienteTestBuilder();
			Cliente cliente = clienteBuilder.getCliente();
			almacenado = clienteService.guardarCliente(cliente);
			Assert.assertNotNull(almacenado.getId());
		}catch(Exception e) {
			Assert.fail();
		}finally {
			if(almacenado.getId() != null) {
				clienteRepository.deleteById(almacenado.getId());
			}
		}
	}
	
	@Test(expected = ServiceException.class)
	public void insertarClienteDuplicadoFail() throws ServiceException {
		Cliente almacenado = new Cliente();
		try {
			ClienteTestBuilder clienteBuilder = new ClienteTestBuilder();
			Cliente clienteUno = clienteBuilder.getCliente();
			Cliente clienteDos = clienteBuilder.getCliente();
			almacenado = clienteService.guardarCliente(clienteUno);
			clienteService.guardarCliente(clienteDos);
		} finally {
			if(almacenado.getId() != null) {
				clienteRepository.deleteById(almacenado.getId());
			}
		}
	}
	
	@Test
	public void actualizarClienteOk() throws ServiceException {
		Cliente cliente = new Cliente();
		try {
			ClienteTestBuilder clienteBuilder = new ClienteTestBuilder();
			cliente = clienteBuilder.getCliente();
			clienteService.guardarCliente(cliente);
			Assert.assertNotNull(cliente.getId());
			
			cliente.setDireccion("Calle 7 Sur");
			clienteService.guardarCliente(cliente);
			
			Cliente clienteConsultado = clienteService.buscarPorIdentificacion(cliente.getIdentificacion());
			Assert.assertEquals("", "Calle 7 Sur", clienteConsultado.getDireccion());
			
		}catch(Exception e) {
			Assert.fail();
		}finally {
			if(cliente.getId() != null) {
				clienteRepository.deleteById(cliente.getId());
			}
		}
	}
	
	@Test(expected = ServiceException.class)
	public void actualizarClienteDuplicadoFail() throws ServiceException {
		Cliente clienteUno = new Cliente();
		Cliente clienteDos = new Cliente();
		try {
			ClienteTestBuilder clienteBuilder = new ClienteTestBuilder();
			clienteUno = clienteBuilder.getCliente();
			clienteDos = clienteBuilder.conIdentificacion("345678").getCliente();
			
			clienteService.guardarCliente(clienteUno);
			clienteService.guardarCliente(clienteDos);
			
			clienteUno.setIdentificacion("345678");
			clienteService.guardarCliente(clienteUno);
		} finally {
			if(clienteUno.getId() != null) {
				clienteRepository.deleteById(clienteUno.getId());
			}
			if(clienteDos.getId() != null) {
				clienteRepository.deleteById(clienteDos.getId());
			}
		}
	}
	
}

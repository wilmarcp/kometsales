package com.kometsales.prueba.api.cliente;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kometsales.prueba.api.domain.Cliente;
import com.kometsales.prueba.api.exceptions.ServiceException;
import com.kometsales.prueba.api.services.ClienteService;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
	
	@Autowired
	private ClienteService clienteService;

	@PostMapping("/registrar")
	@CrossOrigin(origins= "*", methods=RequestMethod.POST, allowedHeaders="*")
	public ResponseEntity<Cliente> registrar(@RequestBody Cliente cliente) throws ServiceException{
		clienteService.guardarCliente(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
	@GetMapping(path="/buscar")
	@CrossOrigin(origins= "*", methods=RequestMethod.GET, allowedHeaders="*")
	public ResponseEntity<List<Cliente>> obtenerClientes()  throws ServiceException {
		return new ResponseEntity<List<Cliente>>(clienteService.obtenerClientes(), HttpStatus.OK);
	}
	
	@GetMapping(path="/buscar/identificacion/{identificacion}")
	@CrossOrigin(origins= "*", methods=RequestMethod.GET, allowedHeaders="*")
	public ResponseEntity<Cliente> buscarPorIdentificacion(@PathVariable ("identificacion") String identificacion)  throws ServiceException {
		Cliente cliente = clienteService.buscarPorIdentificacion(identificacion);
		if(cliente != null) {
			return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		}else {
			return new ResponseEntity<Cliente>(cliente, HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/eliminar/{id}")
	@CrossOrigin(origins= "*", methods=RequestMethod.DELETE, allowedHeaders="*")
	public ResponseEntity<Cliente> eliminarPorId(@PathVariable("id") Integer id)  throws ServiceException {
		clienteService.eliminarPorId(id);
		return new ResponseEntity<Cliente>(HttpStatus.OK);
	}
	
	@PutMapping("/actualizar")
	@CrossOrigin(origins= "*", methods=RequestMethod.PUT, allowedHeaders="*")
	public ResponseEntity<Cliente> actualizarCliente(@RequestBody Cliente cliente)  throws ServiceException {
		clienteService.actualizar(cliente);
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);
	}
	
}

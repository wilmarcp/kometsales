import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import {Observable} from 'rxjs';
import {constantes, Cliente} from '../model';

@Injectable({
  providedIn: 'root'
})
export class ClienteService {

  constructor(private httpClient : HttpClient) { }

  consultarClientes():Observable<Cliente[]>{
    return this.httpClient.get<Cliente[]>(constantes.ENDPOINT_LISTA_CLIENTES);
  }

  consultarClientePorIdentificacion(identificacion : string) : Observable<Cliente>{
    return this.httpClient.get<Cliente>(constantes.ENDPOINT_CONSULTAR_CLIENTE_IDENTIFICACION + identificacion);
  }

  eliminarCliente(cliente : Cliente):Observable<any>{
    return this.httpClient.delete(constantes.ENDPOINT_ELIMINAR_CLIENTE + cliente.id);
  }

  registrarCliente(cliente : Cliente) : Observable<any>{
    return this.httpClient.post(constantes.ENDPOINT_REGISTRAR_CLIENTE, cliente);
  }

  actualizarCliente(cliente : Cliente) : Observable<any>{
    return this.httpClient.put(constantes.ENDPOINT_ACTUALIZAR_CLIENTE, cliente);
  }
}

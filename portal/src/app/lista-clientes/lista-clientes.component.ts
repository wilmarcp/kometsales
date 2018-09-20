import { Component, OnInit } from '@angular/core';
import { ClienteService, AlertService } from '../shared';
import {Cliente} from '../model';
import {from} from 'rxjs';
import {filter, reduce} from 'rxjs/operators';
import { Router } from '@angular/router';

@Component({
  selector: 'app-lista-clientes',
  templateUrl: './lista-clientes.component.html',
  styleUrls: ['./lista-clientes.component.css']
})
export class ListaClientesComponent implements OnInit {

  clientes : Cliente[] = [];
  constructor(private router : Router, 
              private clienteService: ClienteService,
              private alertService: AlertService) { }

  ngOnInit() {
    this.clienteService.consultarClientes().subscribe(response => this.clientes = response);
  }

  eliminar(cliente : Cliente) : void {
    this.clienteService.eliminarCliente(cliente).subscribe(
      response => {
        let clientesActuales : Cliente[] = [];
        from(this.clientes)
          .pipe(filter(data => data.id != cliente.id)).subscribe(data => clientesActuales.push(data));
        this.clientes = clientesActuales;  
        this.alertService.success('Se eliminó el cliente ' + cliente.nombres + ' correctamente', true);
      }, 
      error => {
        this.alertService.error('Lo sentimos, se ha generado un error al intentar actualizar el cliente');
      }
    );
  }

  modificar(cliente : Cliente) : void {
    this.router.navigate(['cliente', {identificacion: cliente.identificacion}]);
  }

}

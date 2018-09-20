import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

import { ActivatedRoute, ParamMap, Router } from '@angular/router';
import { Cliente } from '../model';
import { ClienteService, AlertService } from '../shared';

@Component({
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.css']
})
export class ClienteComponent implements OnInit {

  formularioCliente: FormGroup;
  identificacion : string;
  constructor(private route : ActivatedRoute,
              private router : Router, 
              private formBuilder: FormBuilder,
              private clienteService : ClienteService,
              private alertService: AlertService) { }

  ngOnInit() {
    this.formularioCliente = this.obtenerFormulario();
    this.route.paramMap.subscribe((params : ParamMap) => {
      this.identificacion = params.get('identificacion');
      if(this.identificacion){
        this.clienteService.consultarClientePorIdentificacion(this.identificacion)
        .subscribe(cliente => this.formularioCliente.patchValue(cliente));
      }
    })
  }

  onSubmit() : void{
    if(this.formularioCliente.invalid){
      return;
    }

    let cliente : Cliente = this.formularioCliente.getRawValue();
    if(cliente.id){
      this.actualizarCliente(cliente);
    }else{
      this.registrarCliente(cliente);
    }
  }

  actualizarCliente(cliente : Cliente){
    this.clienteService.actualizarCliente(cliente).subscribe(
      response => {
        this.alertService.success('Se actualizó el cliente ' + cliente.nombres + ' correctamente', true);
        this.router.navigate(['lista-clientes']);
      },
      error => {
        this.alertService.error('Lo sentimos, se ha generado un error al intentar actualizar el cliente');
      });
  }

  registrarCliente(cliente : Cliente) {
    this.clienteService.registrarCliente(cliente).subscribe(
      response => {
        this.alertService.success('Se guardó el cliente ' + cliente.nombres + ' correctamente', true);
        this.router.navigate(['lista-clientes']);
      },
      error => {
        this.alertService.error('Lo sentimos, se ha generado un error al intentar guardar el cliente');
      });
  }

  get controlsCliente(){
    return <FormGroup>this.formularioCliente;
  }

  private obtenerFormulario():FormGroup{
    return this.formBuilder.group({
          id: ['', ''],
          nombres: ['', [Validators.required, Validators.maxLength(200)]],
          primerApellido: ['', [Validators.required, Validators.maxLength(200)]],
          segundoApellido: ['', Validators.maxLength(200)],
          identificacion: ['', [Validators.required, Validators.maxLength(35)]],
          ciudad: ['', Validators.required],
          direccion:['', [Validators.required, Validators.maxLength(255)]],
          telefono: ['', Validators.maxLength(20)],
          celular: ['', [Validators.required, Validators.maxLength(20)]],
          email: ['', [Validators.required, Validators.email, Validators.maxLength(255)]]
    })
  }
}
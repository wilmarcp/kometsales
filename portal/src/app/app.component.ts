import { Component } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html'
})
export class AppComponent {

  constructor(private router : Router){
  }

  ngOnInit() {
  }

  crearCliente(): void{
    this.router.navigate(['cliente']);
  }
  
  listarClientes(): void{
    this.router.navigate(['lista-clientes']);
  }
}

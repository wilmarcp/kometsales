import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { ListaClientesComponent } from './lista-clientes/lista-clientes.component';
import { routing } from './app.routing';
import { HttpClientModule } from '@angular/common/http';

import { MatButtonModule, MatFormFieldModule, MatInputModule, MatSelectModule } from '@angular/material';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';

import { ClienteComponent } from './cliente/cliente.component'
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { AlertComponent } from './alert/alert.component';


@NgModule({
  declarations: [
    AppComponent,
    ListaClientesComponent,
    ClienteComponent,
    AlertComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    routing,
    ReactiveFormsModule,
    FormsModule,
    MatButtonModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    BrowserAnimationsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

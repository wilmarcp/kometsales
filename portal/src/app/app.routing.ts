import {Routes, RouterModule} from '@angular/router';

import { ListaClientesComponent } from './lista-clientes/lista-clientes.component';
import { ClienteComponent } from './cliente/cliente.component';

const appRoutes: Routes = [
    {path: '', component:ListaClientesComponent},
    {path: 'lista-clientes', component:ListaClientesComponent},
    {path: 'cliente', component:ClienteComponent},
    {path:'**', redirectTo:''}
];

export const routing = RouterModule.forRoot(appRoutes);
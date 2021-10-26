import { CidadeCadastroComponent } from './cidade-cadastro.component';
import { RouterModule, Routes } from '@angular/router';
import {ModuleWithProviders} from '@angular/core';


export const routes: Routes = [{path: 'city/cad', component: CidadeCadastroComponent}];

export const CidadeCadastroRoute: ModuleWithProviders<any> = RouterModule.forRoot(routes);


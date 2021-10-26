import { PessoaEditarComponent } from './pessoa-editar.component';
import { RouterModule, Routes } from '@angular/router';
import {ModuleWithProviders} from '@angular/core';


export const routes: Routes = [{path: 'pessoa/editar/:codigo', component: PessoaEditarComponent}];

export const PessoaEditarRoute: ModuleWithProviders<any> = RouterModule.forRoot(routes);


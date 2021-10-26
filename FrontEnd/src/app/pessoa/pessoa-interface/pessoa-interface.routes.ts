import { PessoaInterfaceComponent } from './pessoa-interface.component';
import { RouterModule, Routes } from '@angular/router';
import {ModuleWithProviders} from '@angular/core';


export const routes: Routes = [{path: 'pessoa', component: PessoaInterfaceComponent}];

export const PessoaInterfaceRoute: ModuleWithProviders<any> = RouterModule.forRoot(routes);


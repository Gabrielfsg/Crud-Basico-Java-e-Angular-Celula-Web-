import { PessoaCadastrarComponent } from './pessoa-cadastrar.component';
import { RouterModule, Routes } from '@angular/router';
import {ModuleWithProviders} from '@angular/core';


export const routes: Routes = [{path: 'pessoa/cad', component: PessoaCadastrarComponent}];

export const PessoaCadastrarRoute: ModuleWithProviders<any> = RouterModule.forRoot(routes);


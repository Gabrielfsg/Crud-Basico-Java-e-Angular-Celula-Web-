import { CidadeEditarComponent } from './cidade-editar.component';
import { RouterModule, Routes } from '@angular/router';
import {ModuleWithProviders} from '@angular/core';


export const routes: Routes = [{path: 'city/editar/:codigo', component: CidadeEditarComponent}];

export const CidadeEditarRoute: ModuleWithProviders<any> = RouterModule.forRoot(routes);


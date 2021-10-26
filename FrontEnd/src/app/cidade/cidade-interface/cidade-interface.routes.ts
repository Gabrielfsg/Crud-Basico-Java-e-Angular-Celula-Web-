import { CidadeInterfaceComponent } from './cidade-interface.component';
import { RouterModule, Routes } from '@angular/router';
import {ModuleWithProviders} from '@angular/core';


export const routes: Routes = [{path: 'city', component: CidadeInterfaceComponent}];

export const CidadeInterfaceRoute: ModuleWithProviders<any> = RouterModule.forRoot(routes);


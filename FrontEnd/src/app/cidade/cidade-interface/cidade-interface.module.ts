import { CidadeInterfaceRoute } from './cidade-interface.routes';
import { CidadeInterfaceComponent } from './cidade-interface.component';
import {InputTextModule} from 'primeng/inputtext';
import {DropdownModule} from 'primeng/dropdown';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import { NgModule } from '@angular/core';



@NgModule({

  declarations: [
      CidadeInterfaceComponent
  ],
  imports: [
    CidadeInterfaceRoute,
    InputTextModule,
    DropdownModule,
    ButtonModule,
    TableModule

  ],

})
export class CidadeInterfaceModule { }

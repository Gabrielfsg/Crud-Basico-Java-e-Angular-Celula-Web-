import { PessoaInterfaceRoute } from './pessoa-interface.routes';
import { PessoaInterfaceComponent } from './pessoa-interface.component';
import {InputTextModule} from 'primeng/inputtext';
import {DropdownModule} from 'primeng/dropdown';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import { NgModule } from '@angular/core';
import {PanelModule} from 'primeng/panel';


@NgModule({

  declarations: [
    PessoaInterfaceComponent
  ],
  imports: [
    PessoaInterfaceRoute,
    InputTextModule,
    DropdownModule,
    ButtonModule,
    TableModule,
    PanelModule

  ],

})
export class PessoaInterfaceModule { }

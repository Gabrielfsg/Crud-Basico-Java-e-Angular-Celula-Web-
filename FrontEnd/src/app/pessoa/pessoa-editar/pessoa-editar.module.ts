import { PessoaEditarRoute } from './pessoa-editar.routes';
import { PessoaEditarComponent } from './pessoa-editar.component';
import {InputTextModule} from 'primeng/inputtext';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DropdownModule} from 'primeng/dropdown';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({

  declarations: [
      PessoaEditarComponent
  ],
  imports: [
    PessoaEditarRoute,
    InputTextModule,
    DropdownModule,
    ButtonModule,
    TableModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule

  ],

})
export class PessoaEditarModule { }

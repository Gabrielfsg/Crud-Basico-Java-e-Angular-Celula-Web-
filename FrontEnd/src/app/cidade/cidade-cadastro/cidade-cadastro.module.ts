import { CidadeCadastroRoute } from './cidade-cadastro.routes';
import { CidadeCadastroComponent } from './cidade-cadastro.component';
import {InputTextModule} from 'primeng/inputtext';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DropdownModule} from 'primeng/dropdown';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({

  declarations: [
      CidadeCadastroComponent
  ],
  imports: [
    CidadeCadastroRoute,
    InputTextModule,
    DropdownModule,
    ButtonModule,
    TableModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule

  ],

})
export class CidadeCadastroModule { }

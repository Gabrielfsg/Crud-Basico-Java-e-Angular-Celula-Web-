import { CidadeEditarRoute } from './cidade-editar.routes';
import { CidadeEditarComponent } from './cidade-editar.component';
import {InputTextModule} from 'primeng/inputtext';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DropdownModule} from 'primeng/dropdown';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';


@NgModule({

  declarations: [
      CidadeEditarComponent
  ],
  imports: [
    CidadeEditarRoute,
    InputTextModule,
    DropdownModule,
    ButtonModule,
    TableModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule

  ],

})
export class CidadeEditarModule { }

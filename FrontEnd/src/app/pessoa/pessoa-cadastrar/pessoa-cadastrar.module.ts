import { PessoaCadastrarRoute } from './pessoa-cadastrar.routes';
import {InputTextModule} from 'primeng/inputtext';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {DropdownModule} from 'primeng/dropdown';
import {ButtonModule} from 'primeng/button';
import {TableModule} from 'primeng/table';
import { NgModule } from '@angular/core';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { PessoaCadastrarComponent } from './pessoa-cadastrar.component';


@NgModule({

  declarations: [
      PessoaCadastrarComponent
  ],
  imports: [
    PessoaCadastrarRoute,
    InputTextModule,
    DropdownModule,
    ButtonModule,
    TableModule,
    BrowserAnimationsModule,
    FormsModule,
    ReactiveFormsModule

  ],

})
export class PessoaCadastrarModule { }

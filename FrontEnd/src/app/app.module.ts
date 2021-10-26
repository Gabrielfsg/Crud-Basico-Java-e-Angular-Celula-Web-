import { PessoaEditarModule } from './pessoa/pessoa-editar/pessoa-editar.module';
import { PessoaCadastrarModule } from './pessoa/pessoa-cadastrar/pessoa-cadastrar.module';
import { CidadeService } from './cidade/cidade.service';
import { CidadeInterfaceModule } from './cidade/cidade-interface/cidade-interface.module';
import { RouterModule } from '@angular/router';
import { PessoaService } from './pessoa/pessoa.service';
import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import {PessoaInterfaceModule} from './pessoa/pessoa-interface/pessoa-interface.module';
import { CidadeCadastroModule } from './cidade/cidade-cadastro/cidade-cadastro.module';
import { CidadeEditarModule } from './cidade/cidade-editar/cidade-editar.module';

@NgModule({
  declarations: [
    AppComponent,



  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    PessoaInterfaceModule,
    CidadeInterfaceModule,
    CidadeCadastroModule,
    CidadeEditarModule,
    PessoaCadastrarModule,
    PessoaEditarModule,
    RouterModule
  ],
  providers: [PessoaService, CidadeService],
  bootstrap: [AppComponent]
})
export class AppModule { }

import {BlockUI, NgBlockUI} from 'ng-block-ui';
import { Pessoa } from '../../model/pessoaModel';
import { PessoaService } from '../pessoa.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-pessoa-interface',
  templateUrl: './pessoa-interface.component.html',
  styleUrls: ['./pessoa-interface.component.css']
})

export class PessoaInterfaceComponent implements OnInit {


  pessoa: Pessoa[] = [];
  pessoaPerCod = new Pessoa();
  @BlockUI() blockUI?: NgBlockUI;
  constructor(private pessoaService: PessoaService,
              private router: Router) {}

  ngOnInit(): void {
    this.listarTodasPessoas();
  }

listarTodasPessoas(): void{
  this.pessoaService.listarTodasPessoas().subscribe(pessoa => {
    this.pessoa = pessoa;
  });
}


listarPessoasPerCod(codigoPessoa: number): void{
  this.pessoaService.listarPessoasPerCod(codigoPessoa).subscribe(pessoaPerCod => {
    this.pessoaPerCod = pessoaPerCod;
  });
}

gerarRelatorioPessoa(codigoPessoa: number): void{
  this.pessoaService.gerarRelatorioPessoa(codigoPessoa);
}

deletarPessoa(codigoPessoa: number): void{
  this.pessoaService.deletarPessoa(codigoPessoa).subscribe(() => {
    this.listarTodasPessoas();
  });
}

cadastro(): void{
  this.router.navigate(['pessoa/cad']);
}


editarP(codigoPessoa: number): void{
  this.router.navigate(['pessoa/editar', codigoPessoa]);
}




}

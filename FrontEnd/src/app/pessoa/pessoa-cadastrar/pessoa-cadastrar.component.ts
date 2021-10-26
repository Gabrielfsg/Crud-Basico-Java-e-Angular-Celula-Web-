import { CidadeService } from './../../cidade/cidade.service';
import { PessoaService } from './../pessoa.service';
import { Component, OnInit } from '@angular/core';
import { Cidade } from 'src/app/model/cidadeModel';
import { Pessoa } from 'src/app/model/pessoaModel';

@Component({
  selector: 'app-pessoa-cadastrar',
  templateUrl: './pessoa-cadastrar.component.html',
  styleUrls: ['./pessoa-cadastrar.component.css']
})
export class PessoaCadastrarComponent implements OnInit {

  cidades: Cidade[] = [];
  pessoa = new Pessoa();
  constructor(private pessoaService: PessoaService,
              private cidadeService: CidadeService) { }

  ngOnInit(): void {
    this.listarTodasCidades();
  }

  cadastrarPessoa(): void{
    this.pessoaService.cadastrarPessoa(this.pessoa).subscribe(() => {
      alert(this.pessoa.cidade);
    });
  }

  listarTodasCidades(): void{
    this.cidadeService.listarTodasCidade().subscribe(cidades => {
      this.cidades = cidades;
    });
  }


}

import { PessoaService } from './../pessoa.service';
import { Component, OnInit } from '@angular/core';
import { Pessoa } from 'src/app/model/pessoaModel';
import { CidadeService } from 'src/app/cidade/cidade.service';
import { Cidade } from 'src/app/model/cidadeModel';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-pessoa-editar',
  templateUrl: './pessoa-editar.component.html',
  styleUrls: ['./pessoa-editar.component.css']
})
export class PessoaEditarComponent implements OnInit {
  id = this.route.snapshot.params.codigo;


  cidades: Cidade[] = [];
  pessoa = new Pessoa();
  constructor(private pessoaService: PessoaService,
              private cidadeService: CidadeService,
              private route: ActivatedRoute,
              private routter: Router) { }

  ngOnInit(): void {
    this.listarTodasCidades();
  }

  editarPessoa(): void{
    this.pessoaService.editarPessoa(this.id, this.pessoa).subscribe(() => {
      alert('Sucesso');
      this.routter.navigate(['pessoa']);
    });
  }

  listarTodasCidades(): void{
    this.cidadeService.listarTodasCidade().subscribe(cidades => {
      this.cidades = cidades;
    });
  }

}

import { Estado } from './../../model/estadoModel';
import { Cidade } from './../../model/cidadeModel';
import { CidadeService } from './../cidade.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cidade-cadastro',
  templateUrl: './cidade-cadastro.component.html',
  styleUrls: ['./cidade-cadastro.component.css']
})
export class CidadeCadastroComponent implements OnInit {

  cidade = new Cidade();
  estado: Estado[] = [];
  constructor(private cidadeService: CidadeService,
              private router: Router) { }

  ngOnInit(): void {
    this.listarTodosEstados();
  }

  cadastrarCidade(): void{
    this.cidadeService.cadastrarCidade(this.cidade).subscribe(() => {
      alert(this.cidade);
    });
  }

  listarTodosEstados(): void{
    this.cidadeService.listarTodosEstados().subscribe(estado => {
      this.estado = estado;
    });
  }

  voltarCidadeInterface(): void{
    this.router.navigate(['city']);
  }
}

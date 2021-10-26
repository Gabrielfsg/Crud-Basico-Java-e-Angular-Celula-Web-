import { CidadeService } from './../cidade.service';
import { Cidade } from './../../model/cidadeModel';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cidade-interface',
  templateUrl: './cidade-interface.component.html',
  styleUrls: ['./cidade-interface.component.css']
})
export class CidadeInterfaceComponent implements OnInit {

  cidade: Cidade[] = [];

  constructor(private cidadeService: CidadeService,
              private router: Router) { }

  ngOnInit(): void {
    this.listarTodasCidades();
  }


  listarTodasCidades(): void{
    this.cidadeService.listarTodasCidade().subscribe(cidade => {
      this.cidade = cidade;
    });
  }

  deletarCidade(codigoCidade: number): void{
    this.cidadeService.deletarCidade(codigoCidade).subscribe(() => {
      this.listarTodasCidades();
    });
  }
    cadastro(): void{
      this.router.navigate(['city/cad']);
    }

    editar(codigoCidade: number): void{
      this.router.navigate(['city/editar', codigoCidade]);
    }
}

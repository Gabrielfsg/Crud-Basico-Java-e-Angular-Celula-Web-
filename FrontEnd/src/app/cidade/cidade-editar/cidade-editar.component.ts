import { Cidade } from './../../model/cidadeModel';
import { Component, OnInit } from '@angular/core';
import { Estado } from 'src/app/model/estadoModel';
import { CidadeService } from '../cidade.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-cidade-editar',
  templateUrl: './cidade-editar.component.html',
  styleUrls: ['./cidade-editar.component.css']
})
export class CidadeEditarComponent implements OnInit {
  id = this.route.snapshot.params.codigo;

  estado: Estado[] = [];
  cidade = new Cidade();
  constructor(private cidadeService: CidadeService,
              private route: ActivatedRoute,
              private routter: Router) { }

  ngOnInit(): void {
    this.listarTodosEstados();
  }

  editarCidade(): void{
    this.cidadeService.editarCidade(this.id, this.cidade).subscribe(() => {
      alert('Sucesso');
      this.routter.navigate(['city']);
    });
  }

  listarTodosEstados(): void{
    this.cidadeService.listarTodosEstados().subscribe(estado => {
      this.estado = estado;
    });
  }
}

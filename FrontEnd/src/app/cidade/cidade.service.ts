import { Estado } from './../model/estadoModel';
import { Cidade } from './../model/cidadeModel';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CidadeService {

  cidadeUrl = '/api/city';
  estadoUrl = '/api/estado';

  constructor(private http: HttpClient) { }

    listarTodasCidade(): Observable<Cidade[]>{
      return this.http.get<Cidade[]>(this.cidadeUrl);
    }

    listarTodosEstados(): Observable<Estado[]>{
      return this.http.get<Estado[]>(this.estadoUrl);
    }

    deletarCidade(codigoCidade: number): Observable<Cidade>{
      return this.http.delete<Cidade>(`${this.cidadeUrl}/${codigoCidade}`);
    }

    cadastrarCidade(cidade: Cidade): Observable<Cidade>{
      return this.http.post<Cidade>(this.cidadeUrl, cidade);
    }

    editarCidade(codigoCidade: number, cidade: Cidade): Observable<Cidade>{
      return this.http.put<Cidade>(`${this.cidadeUrl}/${codigoCidade}`, cidade);
    }

}

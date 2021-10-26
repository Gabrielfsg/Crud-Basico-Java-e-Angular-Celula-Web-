
import { Pessoa } from '../model/pessoaModel';
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PessoaService {

  pessoaUrl = '/api/pessoa';


  constructor(private http: HttpClient) {}

    cadastrarPessoa(pessoa: Pessoa): Observable<Pessoa>{
      return this.http.post<Pessoa>(this.pessoaUrl, pessoa);
    }

    listarTodasPessoas(): Observable<Pessoa[]>{
      return this.http.get<Pessoa[]>(this.pessoaUrl);
    }

    listarPessoasPerCod(codigoPessoa: number): Observable<Pessoa>{
      return this.http.get<Pessoa>(`${this.pessoaUrl}/${codigoPessoa}`);
    }

    deletarPessoa(codigoPessoa: number): Observable<Pessoa>{
      return this.http.delete<Pessoa>(`${this.pessoaUrl}/${codigoPessoa}`);
    }

    editarPessoa(codigoPessoa: number, pessoa: Pessoa): Observable<Pessoa>{
      pessoa.codigoPessoa = codigoPessoa;
      return this.http.put<Pessoa>(`${this.pessoaUrl}/${codigoPessoa}`, pessoa);
    }

    gerarRelatorioPessoa(codigoPessoa: number): Observable<Pessoa>{
      return this.http.get<Pessoa>(`${this.pessoaUrl}/${codigoPessoa}/relatorio`);
    }
}

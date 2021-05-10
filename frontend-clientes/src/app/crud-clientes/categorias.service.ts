import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Categoria } from './model/categoria.component';

@Injectable({
  providedIn: 'root'
})
export class CategoriasService {

  private resouceUrl = environment.apiUrl + '/categorias';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  obterTodos(): Observable<Categoria[]> {
    return <Observable<Categoria[]>>this.http.get(this.resouceUrl);
  }

  cadastrar(categoria: Categoria): Observable<Categoria> {
    return <Observable<Categoria>>this.http
      .post(this.resouceUrl, JSON.stringify(categoria), this.httpOptions);
  }

  obterPorId(id: number): Observable<Categoria> {
    return <Observable<Categoria>>this.http
      .get(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  excluirPorId(id: number) {
    return <Observable<Categoria>>this.http
      .delete(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  atualizar(categoria: Categoria): Observable<Categoria> {
    return <Observable<Categoria>>this.http
      .put(this.resouceUrl, JSON.stringify(categoria), this.httpOptions);
  }
}

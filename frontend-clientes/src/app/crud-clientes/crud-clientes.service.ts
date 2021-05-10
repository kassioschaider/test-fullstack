import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Cliente } from './model/cliente.model';

@Injectable({
  providedIn: 'root'
})
export class CrudClientesService {

  private resouceUrl = environment.apiUrl + '/clientes';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  obterTodos(): Observable<Cliente[]> {
    return <Observable<Cliente[]>>this.http.get(this.resouceUrl);
  }

  cadastrar(cliente: Cliente): Observable<Cliente> {
    return <Observable<Cliente>>this.http
      .post(this.resouceUrl, JSON.stringify(cliente), this.httpOptions);
  }

  obterPorId(id: number): Observable<Cliente> {
    return <Observable<Cliente>>this.http
      .get(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  excluirPorId(id: number) {
    return <Observable<Cliente>>this.http
      .delete(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  atualizar(cliente: Cliente): Observable<Cliente> {
    return <Observable<Cliente>>this.http
      .put(this.resouceUrl, JSON.stringify(cliente), this.httpOptions);
  }
}

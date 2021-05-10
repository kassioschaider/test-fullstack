import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Email } from './model/email.model';

@Injectable({
  providedIn: 'root'
})
export class EmailsService {

  private resouceUrl = environment.apiUrl + '/emails';
  private httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json'
    })
  }

  constructor(private http: HttpClient) { }

  obterTodos(): Observable<Email[]> {
    return <Observable<Email[]>>this.http.get(this.resouceUrl);
  }

  cadastrar(email: Email): Observable<Email> {
    return <Observable<Email>>this.http
      .post(this.resouceUrl, JSON.stringify(email), this.httpOptions);
  }

  obterPorId(id: number): Observable<Email> {
    return <Observable<Email>>this.http
      .get(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  excluirPorId(id: number) {
    return <Observable<Email>>this.http
      .delete(this.resouceUrl + '/' + JSON.stringify(id), this.httpOptions);
  }

  atualizar(email: Email): Observable<Email> {
    return <Observable<Email>>this.http
      .put(this.resouceUrl, JSON.stringify(email), this.httpOptions);
  }
}

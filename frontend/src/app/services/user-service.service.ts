import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserServiceService {

  constructor(private http: HttpClient) { }

  cadastrar(user: any): Observable<any> {
    return this.http.post('http://localhost:8080/user/create', user);
  }

  login(credentials: any): Observable<any> {
    return this.http.post('http://localhost:8080/user/login', credentials);
  }
}

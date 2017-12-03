import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse} from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import {User} from './User';

@Injectable()
export class AuthenticationService {
  public token: any;
  readonly  ROOT_URL = 'https://2983.239847.239847.234'
  constructor(private http: HttpClient) {
  }
  login (username: string, password: string): Observable<any> {
    return this.http.post(this.ROOT_URL, JSON.stringify({ username: username, password: password }))
      .map((response: Response) => {
        // login successful if there's a jwt token in the response
        let user = response;
        if (user) {
          // store user details  in local storage to keep user logged in between page refreshes
          localStorage.setItem('currentUser', JSON.stringify(user));
        }
      });
  }

  logout() {
    localStorage.removeItem('currentUser');
  }
}

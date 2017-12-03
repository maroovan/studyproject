import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders, HttpResponse, HttpRequest  } from '@angular/common/http';

import { LocalStorageService } from 'angular-2-local-storage';

import { User } from './user';
import { Observable } from 'rxjs/Rx';

@Injectable()
export class UserService {
  readonly  ROOT_URL = 'https://2983.239847.239847.234/users'
  constructor(
    // private http: HttpClient
    private localStorageService: LocalStorageService
  ) { }

  getAll() {
    // return this.http.get(this.ROOT_URL);
  }

  getById(id: number) {
    // return this.http.get(this.ROOT_URL + id);
  }

  create(user: User) {
    // return this.http.post(this.ROOT_URL , user);
    this.localStorageService.set('user', user);
    return Observable.of(this.localStorageService);
  }

  update(user: User) {
    // return this.http.put(this.ROOT_URL + user.id, user);
  }

  delete(id: number) {
    // return this.http.delete(this.ROOT_URL + id);
  }
}

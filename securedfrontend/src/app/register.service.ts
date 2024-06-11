import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http: HttpClient) { }

  postUserData(username: string, email: string, password: string) {
  const url = `http://localhost:8080/user/register`;
  return this.http.post(url, {username, email, password});
}

}


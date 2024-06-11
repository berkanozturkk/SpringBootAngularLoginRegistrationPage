import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {


  constructor(private http:HttpClient, private router: Router) { }

  get loggedInUsername(): string {
    return localStorage.getItem('loggedInUsername') || '';
  }

  set loggedInUsername(value: string) {
    localStorage.setItem('loggedInUsername', value);
  }

  getUserData(username: string,password: string){
    const url = `http://localhost:8080/user`;
    return this.http.post(url, {username, password});
  }

  logout(){
    localStorage.clear();
    this.router.navigate([""]);
  }

}

import { Component, OnInit } from '@angular/core';
import { LoginserviceService } from '../loginservice.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{
  model: any = {}
  getData: boolean | undefined;
  
  constructor(private loginservice :LoginserviceService, private router: Router){ }
  
  
  
  ngOnInit(){ }

  loginUser(){
    var username = this.model.username;
    var password = this.model.password;
    this.loginservice.getUserData(username,password).subscribe((res)=>{
      this.getData = res as boolean;
      

      if(this.getData == true)
      {
        this.loginservice.loggedInUsername = username;
        this.router.navigate(["/homepage"]);
      }
      else{
        alert("Invalid username or password!")
      }
    })
  }
  
  routeRegister(){
    this.router.navigate(["/register"]);
  }

}

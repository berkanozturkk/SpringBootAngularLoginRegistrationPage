import { Component } from '@angular/core';
import { RegisterService } from '../register.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent{
  model: any = {};
  getData: any | undefined;

  constructor(private register: RegisterService , private router: Router) {
    this.router = router;
  }

 

  registUser() {
    var username = this.model.username;
    var email = this.model.email;
    var password = this.model.password;
    if (!this.model.username || !this.model.email || !this.model.password) {
      alert("Please fill in all fields.");
      return;
    }
    else{
      this.register.postUserData(username, email, password ).subscribe(
        (res: any) => {
          this.getData = res as boolean;
          if (this.getData == 1) {
            alert('User registered successfully!');
            this.router.navigate(['']);
          } else {
            alert('Fill the fields correctly!');
          }
        }
      );

    }
   
  }
  
  
}

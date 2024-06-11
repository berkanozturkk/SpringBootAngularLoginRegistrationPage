import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LoginserviceService } from '../loginservice.service';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  

  constructor(
    private loginservice: LoginserviceService,
  ) {}

  ngOnInit() {}

  get loggedInUserName(): string {
    return this.loginservice.loggedInUsername;
  }

  logout(){
    this.loginservice.logout();
  }
}
import { Component, OnInit } from '@angular/core';

import { RegistrationService } from 'src/app/services/registration.service';
import {Router} from "@angular/router";
import { Admin } from 'src/app/modules/user';
import {NgForm} from "@angular/forms";
@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})

export class AdminComponent implements OnInit {



  admin = new Admin();
  msg;
  
  
  
    constructor(private _service: RegistrationService,private _router: Router) { }
  
    ngOnInit(): void {
    }
  
   adminLogin(){
   
      this._service.loginAdmin(this.admin).subscribe(
        responseData =>
        {
        //window.localStorage.setItem("manager", responseData.name);
        console.log("response recived");
        this._router.navigate(["/dashboard"]);
      },
      error =>{
        console.log("exception occured");
        this.msg="Bad credentials,Please enter valid email and password";
      }

      )
    }
  
}

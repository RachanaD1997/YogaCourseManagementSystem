import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { FormControl , Validators} from '@angular/forms';
import {NgForm} from '@angular/forms';
import { Router } from '@angular/router';
import { RegistrationService } from '../../app/services/registration.service';
import { User } from '../../app/modules/user';


@Component({
  selector: 'app-register-user',
  templateUrl: './register-user.component.html',
  styleUrls: ['./register-user.component.css']
})



export class RegisterUserComponent implements OnInit {
  alert:boolean=false
user=new User();
msg='';

  constructor(private _service : RegistrationService,private _router : Router) { }

 
  ngOnInit(): void {
  }

  loginUser(){
    this._service.loginUserFromRemote(this.user).subscribe(
    data =>{console.log("respose received");
    this._router.navigate(["/loginsuccess"]);
  },
    error =>{
      console.log("exception occured");
      this.msg="Bad credentials,Please enter valid email and password";
    }
    )
  }
  register(){
    this._service.registerUserFormRemote(this.user).subscribe(
      data=>{
        console.log("responce received");
        this._router.navigate(["/login"]);
        this.alert=true
      },
      error=>{
        console.log("exception occured");
        this.msg=error.error;
      }
    )
    this.alert=true
  }

}

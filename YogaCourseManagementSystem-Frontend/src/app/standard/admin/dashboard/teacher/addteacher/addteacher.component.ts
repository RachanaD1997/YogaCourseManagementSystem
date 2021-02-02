import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Teacher } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-addteacher',
  templateUrl: './addteacher.component.html',
  styleUrls: ['./addteacher.component.css']
})
export class AddteacherComponent implements OnInit {

  alert:boolean=false
  
  constructor(private _service:RegistrationService,private _router:Router) { }
  teacher = new Teacher();

  ngOnInit(): void {
  }

  addTeacher(){

    this._service.addTeacher(this.teacher).subscribe
    (
      data =>
      {
     
        console.log("data added successfull");
        this._router.navigate(['teacher']);
        this.alert=true 
      },
      error =>console.log("error")
    )
    this.alert=true
  }

  
back(){
  console.log('go back');
  this._router.navigate(['taecher']);
}

}


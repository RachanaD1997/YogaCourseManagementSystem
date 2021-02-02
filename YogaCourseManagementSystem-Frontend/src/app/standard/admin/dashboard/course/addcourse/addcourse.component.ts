import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-addcourse',
  templateUrl: './addcourse.component.html',
  styleUrls: ['./addcourse.component.css']
})
export class AddcourseComponent implements OnInit {

  alert:boolean=false
  
  constructor(private _service:RegistrationService,private _router:Router) { }
  course = new Course();

  ngOnInit(): void {
  }

  addCourse(){

    this._service.addCourse(this.course).subscribe
    (
      data =>
      {
     
        console.log("data added successfull");
        this._router.navigate(['course']);
        this.alert=true 
      },
      error =>console.log("error")
    )
    this.alert=true
  }

  
back(){
  console.log('go back');
  this._router.navigate(['course']);
}

}

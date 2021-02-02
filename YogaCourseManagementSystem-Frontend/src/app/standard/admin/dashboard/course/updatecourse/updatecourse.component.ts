import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-updatecourse',
  templateUrl: './updatecourse.component.html',
  styleUrls: ['./updatecourse.component.css']
})
export class UpdatecourseComponent implements OnInit {

  alert:boolean=false
  
  constructor(private _service:RegistrationService,private _router:Router,private _activatedRoute :ActivatedRoute) { }
  course = new Course();


  ngOnInit(): void {
    let id = this._activatedRoute.snapshot.paramMap.get('id');
    this._service.fetchCourseById(id).subscribe(
      data=>{
      console.log("data recieved");
      this.course=data;
    },
    error => console.log("expection occured ")
    
    )
  }

  updateCourse(){
    let id = this._activatedRoute.snapshot.paramMap.get('id');

    this._service.updateCourse(id,this.course).subscribe
    (
      data =>
      {
     
        console.log("data added successfull");
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

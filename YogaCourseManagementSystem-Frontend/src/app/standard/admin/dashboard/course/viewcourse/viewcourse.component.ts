import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Course } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-viewcourse',
  templateUrl: './viewcourse.component.html',
  styleUrls: ['./viewcourse.component.css']
})
export class ViewcourseComponent implements OnInit {

  course= new Course();
  constructor(private _service:RegistrationService,private _router:Router, private _activatedRoute :ActivatedRoute) {}

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
 gotolist(){
    console.log('go back');
    this._router.navigate(['course']);
  }
  }
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Course } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-course',
  templateUrl: './course.component.html',
  styleUrls: ['./course.component.css']
})
export class CourseComponent implements OnInit {

  courses: Course[];
  constructor(private _service:RegistrationService,private _router:Router) { }

  ngOnInit(): void {
  
  this._service.fetchCourseList().subscribe(
    data => {
      console.log("response recieved", data);
      this.courses = data;
    },
    error=>console.log("exception occured")
  ) 
  }
  back(){
    console.log('go back');
    this._router.navigate(['dashboard']);
  }


  viewCourse(id : string){
    console.log("id" + id);
    this._router.navigate(["/viewcourse", id]);
  }
  
logout(){
console.log('go back');
this._router.navigate(['admin']);
}

delete(id: string){

this._service.deleteCourseById(id).subscribe(

  data =>{ 
     console.debug("deleted automatically");
     this._router.navigate(["/course"]);
    
  }
)
}
addnewcourse()
{
  console.log('go back');
  this._router.navigate(['addcourse']);
}
EditCourse(id:number){
  console.log("id" + id);
      this._router.navigate(["/updatecourse",id]);
}

}


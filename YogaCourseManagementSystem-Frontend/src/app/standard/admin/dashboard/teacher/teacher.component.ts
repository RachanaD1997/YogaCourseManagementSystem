import { Component, OnInit } from '@angular/core';
import { Teacher } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-teacher',
  templateUrl: './teacher.component.html',
  styleUrls: ['./teacher.component.css']
})
export class TeacherComponent implements OnInit {

  teachers: Teacher[];
  constructor(private _service:RegistrationService,private _router:Router) { }

  ngOnInit(): void {
  
  this._service.fetchTeacherList().subscribe(
    data => {
      console.log("response recieved", data);
      this.teachers = data;
    },
    error=>console.log("exception occured")
  ) 
  }
  back(){
    console.log('go back');
    this._router.navigate(['dashboard']);
  }


  viewTeacher(id : string){
    console.log("id" + id);
    this._router.navigate(["/viewteacher", id]);
  }
  
logout(){
console.log('go back');
this._router.navigate(['admin']);
}

delete(id: string){

this._service.deleteTeacherById(id).subscribe(

  data =>{ 
     console.debug("deleted automatically");
     this._router.navigate(["/teacher"]);
    
  }
)

}
addnewteacher(){
  console.log('go back');
  this._router.navigate(['addteacher']);
}

EditTeacher(id:number){
  console.log("id" + id);
      this._router.navigate(["/updateteacher",id]);
}
  
}
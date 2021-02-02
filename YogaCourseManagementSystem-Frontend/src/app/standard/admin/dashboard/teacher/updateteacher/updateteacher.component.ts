import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Teacher } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-updateteacher',
  templateUrl: './updateteacher.component.html',
  styleUrls: ['./updateteacher.component.css']
})
export class UpdateteacherComponent implements OnInit {

  alert:boolean=false
  
  constructor(private _service:RegistrationService,private _router:Router,private _activatedRoute :ActivatedRoute) { }
  teacher = new Teacher();


  ngOnInit(): void {
    let id = this._activatedRoute.snapshot.paramMap.get('id');
    this._service.fetchTeacherById(id).subscribe(
      data=>{
      console.log("data recieved");
      this.teacher=data;
    },
    error => console.log("expection occured ")
    
    )
  }

  updateTeacher(){
    let id = this._activatedRoute.snapshot.paramMap.get('id');

    this._service.updateTeacher(id,this.teacher).subscribe
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
    this._router.navigate(['teacher']);
  }

}

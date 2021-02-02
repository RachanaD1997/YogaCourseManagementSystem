import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Teacher } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-viewteacher',
  templateUrl: './viewteacher.component.html',
  styleUrls: ['./viewteacher.component.css']
})
export class ViewteacherComponent implements OnInit {

  teacher= new Teacher();
  constructor(private _service:RegistrationService,private _router:Router, private _activatedRoute :ActivatedRoute) {}

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
 gotolist(){
    console.log('go back');
    this._router.navigate(['teacher']);
  }
  }

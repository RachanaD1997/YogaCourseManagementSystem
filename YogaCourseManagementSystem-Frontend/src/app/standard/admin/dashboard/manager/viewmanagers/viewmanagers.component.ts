import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Manager } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-viewmanagers',
  templateUrl: './viewmanagers.component.html',
  styleUrls: ['./viewmanagers.component.css']
})
export class ViewmanagersComponent implements OnInit {

  manager= new Manager();
  constructor(private _service:RegistrationService,private _router:Router, private _activatedRoute :ActivatedRoute) {}

  ngOnInit(): void {

    let id = this._activatedRoute.snapshot.paramMap.get('id');
    this._service.fetchManagerById(id).subscribe(
      data=>{
      console.log("data recieved");
      this.manager=data;
    },
    error => console.log("expection occured ")
    
    )
  }
 gotolist(){
    console.log('go back');
    this._router.navigate(['manager']);
  }
  }




import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Center } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-viewcenter',
  templateUrl: './viewcenter.component.html',
  styleUrls: ['./viewcenter.component.css']
})
export class ViewcenterComponent implements OnInit {

  center= new Center();
  constructor(private _service:RegistrationService,private _router:Router, private _activatedRoute :ActivatedRoute) {}

  ngOnInit(): void {

    let id = this._activatedRoute.snapshot.paramMap.get('id');
    this._service.fetchCenterById(id).subscribe(
      data=>{
      console.log("data recieved");
      this.center=data;
    },
    error => console.log("expection occured ")
    
    )
  }
 gotolist(){
    console.log('go back');
    this._router.navigate(['center']);
  }
  }

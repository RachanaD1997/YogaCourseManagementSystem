import { Route } from '@angular/compiler/src/core';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Center } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-updatecenter',
  templateUrl: './updatecenter.component.html',
  styleUrls: ['./updatecenter.component.css']
})
export class UpdatecenterComponent implements OnInit {

  alert:boolean=false
  center = new Center();

  constructor(private _service:RegistrationService,private _router:Router,private _activatedRoute :ActivatedRoute) { }
  

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

  updateCenter(){
    let id = this._activatedRoute.snapshot.paramMap.get('id');
    this._service.updateCenter(id,this.center).subscribe
    (
      data =>
      {
     
        console.log("data updated successfull");
        //this._router.navigate(['center']);

        this.alert=true 
      },
      error =>console.log("error")
    )
    this.alert=true
  }
  
    
  back(){
    console.log('go back');
    this._router.navigate(['center']);
  }

}


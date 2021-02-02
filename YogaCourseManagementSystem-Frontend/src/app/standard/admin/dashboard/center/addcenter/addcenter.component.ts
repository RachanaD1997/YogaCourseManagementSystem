import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Center } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-addcenter',
  templateUrl: './addcenter.component.html',
  styleUrls: ['./addcenter.component.css']
})
export class AddcenterComponent implements OnInit {

  alert:boolean=false
  
  center = new Center();
  constructor(private _service:RegistrationService,private _router:Router) { }
 

  ngOnInit(): void {
  }

  addCenter(){

    this._service.addCenter(this.center).subscribe
    (
      data =>
      {
     
        console.log("data added successfull");
        this._router.navigate(['center']);
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

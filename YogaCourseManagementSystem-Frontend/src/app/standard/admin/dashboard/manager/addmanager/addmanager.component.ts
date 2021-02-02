import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Manager } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';



@Component({
  selector: 'app-addmanager',
  templateUrl: './addmanager.component.html',
  styleUrls: ['./addmanager.component.css']
})
export class AddmanagerComponent implements OnInit {

  alert:boolean=false
  
  constructor(private _service:RegistrationService,private _router:Router) { }
  manager = new Manager();

  ngOnInit(): void {
  }

  addManager(){

    this._service.addManager(this.manager).subscribe
    (
      data =>
      {
     
        console.log("data added successfull");
        this._router.navigate(['manager']);
        this.alert=true 
      },
      error =>console.log("error")
    )
    this.alert=true
  }

  
back(){
  console.log('go back');
  this._router.navigate(['manager']);
}

}

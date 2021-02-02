import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Manager } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-update',
  templateUrl: './update.component.html',
  styleUrls: ['./update.component.css']
})
export class UpdateComponent implements OnInit {

  alert:boolean=false
  manager = new Manager();
  constructor(private _service:RegistrationService,private _router:Router,private _activatedRoute :ActivatedRoute) { }



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

  updateManager(){
    this._service.addManager(this.manager).subscribe
    (
      data =>
      {
     
        console.log("data updated successfull");
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

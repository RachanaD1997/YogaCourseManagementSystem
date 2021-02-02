import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Center } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-center',
  templateUrl: './center.component.html',
  styleUrls: ['./center.component.css']
})
export class CenterComponent implements OnInit {

  centers: Center[];
  constructor(private _service:RegistrationService,private _router:Router) { }

 

  ngOnInit(): void {
  
    this._service.fetchCenterList().subscribe(
      data => {
        console.log("response recieved", data);
        this.centers = data;
      },
      error=>console.log("exception occured")
    ) 
    }
    back(){
      console.log('go back');
      this._router.navigate(['dashboard']);
    }
  
  
    viewCenter(id : string){
      console.log("id" + id);
      this._router.navigate(["/viewcenter",id]);
    }
    
  logout(){
  console.log('go back');
  this._router.navigate(['admin']);
  }
  
  delete(id: string){
  
  this._service.deleteCenterById(id).subscribe(
  
    data =>{ 
       console.debug("deleted automatically");
       this._router.navigate(["/center"]);
      
    }
  )
  
  }

  addnewcenter(){
    console.log('go back');
    this._router.navigate(['addcenter']);
  }
  
  EditCenter(id:number){
    console.log("id" + id);
        this._router.navigate(["/updatecenter",id]);
  }
    
  }
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Manager } from 'src/app/modules/user';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-manager',
  templateUrl: './manager.component.html',
  styleUrls: ['./manager.component.css']
})
export class ManagerComponent implements OnInit {

  managers: Manager[];
  constructor(private _service:RegistrationService,private _router:Router) { }

  ngOnInit(): void {
  
  this._service.fetchManagerList().subscribe(
    data => {
      console.log("response recieved", data);
      this.managers = data;
    },
    error=>console.log("exception occured")
  ) 
  }
  back(){
    console.log('go back');
    this._router.navigate(['dashboard']);
  }


  viewManager(id : string){
    console.log("id" + id);
    this._router.navigate(["/viewmanager", id]);
  }
  
logout(){
console.log('go back');
this._router.navigate(['admin']);
}

delete(id: number){
 // console.log(this.id);
this._service.deleteManagerById(id).subscribe(
  
  data =>{ 
     console.debug("deleted automatically");
     this._router.navigate(["/manager"]);
    // console.log(this.id);
    
  }
)

}

addnewmanager(){
  console.log('go back');
  this._router.navigate(['addmanager']);
}

EditManager(id:number){
  console.log("id" + id);
      this._router.navigate(["/update",id]);
}
  
}
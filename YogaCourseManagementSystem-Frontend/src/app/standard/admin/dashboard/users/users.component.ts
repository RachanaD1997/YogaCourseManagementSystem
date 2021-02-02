import { Component, OnInit } from '@angular/core';
import { Users } from 'src/app/modules/user';
import { Router } from '@angular/router';
import { RegistrationService } from 'src/app/services/registration.service';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  userss: Users[];
  constructor(private _service:RegistrationService,private _router:Router) { }

  ngOnInit(): void {
  
  this._service.fetchUserList().subscribe(
    data => {
      console.log("response recieved", data);
      this.userss = data;
    },
    error=>console.log("exception occured")
  ) 
  }
  back(){
    console.log('go back');
    this._router.navigate(['dashboard']);
  }


  viewUser(id : string){
    console.log("id" + id);
    this._router.navigate(["/viewuser", id]);
  }
  
logout(){
console.log('go back');
this._router.navigate(['admin']);
}

delete(id: string){

this._service.deleteUserById(id).subscribe(

  data =>{ 
     console.debug("deleted automatically");
     this._router.navigate(["/user"]);
    
  }
)

}


}

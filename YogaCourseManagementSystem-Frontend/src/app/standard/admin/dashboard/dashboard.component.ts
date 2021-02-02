import { Component, OnInit } from '@angular/core';

import { RegistrationService } from 'src/app/services/registration.service';
import {Router} from "@angular/router";


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  constructor(private router: Router){
  }

  ngOnInit(): void {
  }

  managerDetails(){

    this.router.navigate(["/manager"]);
  }
  
  centerDetails(){

     this.router.navigate(["/center"]);
   }
   courseDetails(){

     this.router.navigate(["/course"]);
   }
   teacherDetails(){

     this.router.navigate(["/teacher"]);
   }

   userDetails(){

     this.router.navigate(["/user"]);
   }
   gotolist(){
     console.log('go back');
     this.router.navigate(['admin']);
 }


}

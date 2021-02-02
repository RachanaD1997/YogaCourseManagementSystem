import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-applycourse',
  templateUrl: './applycourse.component.html',
  styleUrls: ['./applycourse.component.css']
})
export class ApplycourseComponent implements OnInit {

  constructor(private _router : Router) { }

  ngOnInit(): void {
  }

  gotologinpage(){
 
    this._router.navigate(['/registercourse']);
  }
}

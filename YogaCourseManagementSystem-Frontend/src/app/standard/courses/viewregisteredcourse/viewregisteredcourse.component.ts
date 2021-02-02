import { Component, OnInit } from '@angular/core';
import { Course } from 'src/app/modules/user';

@Component({
  selector: 'app-viewregisteredcourse',
  templateUrl: './viewregisteredcourse.component.html',
  styleUrls: ['./viewregisteredcourse.component.css']
})
export class ViewregisteredcourseComponent implements OnInit {

  cartArray:Course[]=[];
  courseId:number;
  data:JSON;
  constructor() { }

  ngOnInit(): void {
    this.getSelectedCourse();
  }

  getSelectedCourse(){
    this.cartArray=JSON.parse(sessionStorage.getItem('Cart'));
    console.log(JSON.parse(sessionStorage.getItem('Cart')));
   
    console.log(this.cartArray);
    

  }

}

import { Component, OnInit } from '@angular/core';
import { Course } from '../modules/user';
import { RegistrationService } from '../services/registration.service';

@Component({
  selector: 'app-registercourse',
  templateUrl: './registercourse.component.html',
  styleUrls: ['./registercourse.component.css']
})
export class RegistercourseComponent implements OnInit {

  

  course:Course[];
  cartCourse:Course;
  cartArray:Course[]=[];

  constructor(private service:RegistrationService) { }

  ngOnInit(): void {
    this.fetchCourseList();
  }
  fetchCourseList() {
    this.service.fetchCourseList().subscribe(
      data=>{
        this.course=data as Course[];
        console.log("Data Received");
      },error=>{
        console.log("data receiver fails..!!");
      }
    );
  }

  Cart:number[]=[];

  AddToCart(courseId)
  {
    //console.log("shopping cart id "+prodId);
    //sessionStorage.setItem('shoppingCart', JSON.stringify({productId:prodId}));
    this.service.fetchCourseById(courseId).subscribe(
      data=>{
        this.cartCourse= data as Course;
        this.cartArray.push(this.cartCourse);
        sessionStorage.setItem('Cart', JSON.stringify({array :this.cartArray}));
        alert("Course Register Successfully..!!")
        
      },error=>console.log("Failed ")
    );
    //this.cartArray.push(this.cartProduct);
  }

}


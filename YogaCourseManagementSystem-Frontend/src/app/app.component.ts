import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ECommerceSPAApp';
  count=45;
  
  product={
    id:12,
    title:"Rose",
    description:"Valentine best Flower",
    unitPrice:145,
    quantity:4500,
    likes:560
  };

  public onClick1(){
    this.product.likes++;

  }

  public onClick2(){
     this.product.likes--;
  }

}

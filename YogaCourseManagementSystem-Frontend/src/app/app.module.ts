import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule} from "@angular/forms";
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MDBBootstrapModule } from 'angular-bootstrap-md';
import { MatButtonModule } from '@angular/material/button';
import { MatCardModule } from '@angular/material/card';
import { MatTabsModule } from '@angular/material/tabs';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { RegisterUserComponent } from './register-user/register-user.component';
import { MatIconModule } from '@angular/material/icon';
import { SPAModule } from './spa/spa.module';

import { HttpClientModule } from '@angular/common/http';
import { ApplycourseComponent } from './applycourse/applycourse.component';
import { LogoutComponent } from './logout/logout.component';
import { RegistercourseComponent } from './registercourse/registercourse.component'




@NgModule({
  declarations: [AppComponent,RegisterUserComponent,ApplycourseComponent,LogoutComponent,RegistercourseComponent],
  imports: [
    MDBBootstrapModule.forRoot(),
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule, 
    BrowserAnimationsModule,
    MatInputModule,
    MatCardModule,
    MatTabsModule,
    MatFormFieldModule,    
    MatButtonModule,
    MatCheckboxModule,
    MatToolbarModule,
    MatIconModule,
    SPAModule,
],
 
  bootstrap: [AppComponent]
})
export class AppModule { }

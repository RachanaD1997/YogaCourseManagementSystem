import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { StandardModule } from '../standard/standard.module';
import { Routes,RouterModule } from '@angular/router';
import { CentersComponent } from '../standard/centers/centers.component';
import { CoursesComponent } from '../standard/courses/courses.component';
import { AboutusComponent } from '../standard/aboutus/aboutus.component';
import { ContactusComponent } from '../standard/contactus/contactus.component';
import { HomepageComponent } from './homepage/homepage.component';
import { RegisterUserComponent } from '../register-user/register-user.component';
import { HomeComponent } from '../standard/home/home.component';
import { MatIconModule } from '@angular/material/icon';
import { MatToolbarModule } from '@angular/material/toolbar';
import { MatButtonModule } from '@angular/material/button';
import { AdminComponent } from '../standard/admin/admin.component';
import { TeacherComponent } from '../standard/admin/dashboard/teacher/teacher.component';
import { TeachersComponent } from '../standard/teachers/teachers.component';


const routes: Routes = [

  { path:'',redirectTo:'home',pathMatch:'full'},
  { path:'home',component:HomeComponent},
   { path:'userlogin', component: RegisterUserComponent },
   { path:'centers', component: CentersComponent },
   { path:'courses', component: CoursesComponent },
   { path:'aboutus', component: AboutusComponent },
   { path:'contactus', component: ContactusComponent },
   { path:'adminlogin' ,component:AdminComponent},
   { path:'teachers' ,component:TeachersComponent},

];



@NgModule({
  declarations: [HomepageComponent],
  imports: [
    CommonModule,
    StandardModule,
    RouterModule.forRoot(routes),
    MatToolbarModule,
    MatIconModule,
    MatButtonModule
  ],
  exports:[HomepageComponent]
})
export class SPAModule { }

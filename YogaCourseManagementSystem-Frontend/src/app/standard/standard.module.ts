import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CentersComponent } from './centers/centers.component';
import { CoursesComponent } from './courses/courses.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { HomeComponent } from './home/home.component';
import { AdminComponent } from './admin/admin.component';
import { FormsModule } from '@angular/forms';
import { DashboardComponent } from './admin/dashboard/dashboard.component';
import { Center1Component } from './center1/center1.component';
import { Center2Component } from './center2/center2.component';
import { Center3Component } from './center3/center3.component';
import { Center4Component } from './center4/center4.component';
import { Center5Component } from './center5/center5.component';
import { Center6Component } from './center6/center6.component';
import { ManagerComponent } from './admin/dashboard/manager/manager.component';
import { CenterComponent } from './admin/dashboard/center/center.component';
import { CourseComponent } from './admin/dashboard/course/course.component';
import { TeacherComponent } from './admin/dashboard/teacher/teacher.component';
import { UsersComponent } from './admin/dashboard/users/users.component';
import { ViewmanagersComponent } from './admin/dashboard/manager/viewmanagers/viewmanagers.component';
import { ViewcenterComponent } from './admin/dashboard/center/viewcenter/viewcenter.component';
import { ViewcourseComponent } from './admin/dashboard/course/viewcourse/viewcourse.component';
import { ViewteacherComponent } from './admin/dashboard/teacher/viewteacher/viewteacher.component';
import { ViewusersComponent } from './admin/dashboard/users/viewusers/viewusers.component';
import { AddmanagerComponent } from './admin/dashboard/manager/addmanager/addmanager.component';
import { UpdateComponent } from './admin/dashboard/manager/update/update.component';
import { AddcenterComponent } from './admin/dashboard/center/addcenter/addcenter.component';
import { UpdatecenterComponent } from './admin/dashboard/center/updatecenter/updatecenter.component';
import { AddcourseComponent } from './admin/dashboard/course/addcourse/addcourse.component';
import { UpdatecourseComponent } from './admin/dashboard/course/updatecourse/updatecourse.component';
import { UpdateteacherComponent } from './admin/dashboard/teacher/updateteacher/updateteacher.component';
import { AddteacherComponent } from './admin/dashboard/teacher/addteacher/addteacher.component';
import { AdduserComponent } from './admin/dashboard/users/adduser/adduser.component';
import { UpdateuserComponent } from './admin/dashboard/users/updateuser/updateuser.component';
import { ViewregisteredcourseComponent } from './courses/viewregisteredcourse/viewregisteredcourse.component';
import { TeachersComponent } from './teachers/teachers.component';



@NgModule({
  declarations: [CentersComponent, CoursesComponent, AboutusComponent, 
    ContactusComponent,  HomeComponent, AdminComponent, DashboardComponent, Center1Component, Center2Component, Center3Component, Center4Component, Center5Component, Center6Component, ManagerComponent, CenterComponent, CourseComponent, TeacherComponent, UsersComponent, ViewmanagersComponent, ViewcenterComponent, ViewcourseComponent, ViewteacherComponent, ViewusersComponent, AddmanagerComponent, UpdateComponent, AddcenterComponent, UpdatecenterComponent, AddcourseComponent, UpdatecourseComponent, UpdateteacherComponent, AddteacherComponent, AdduserComponent, UpdateuserComponent, ViewregisteredcourseComponent, TeachersComponent],
  imports: [
    CommonModule,FormsModule
  ],
  exports:[CentersComponent, CoursesComponent, AboutusComponent, ContactusComponent,
     ]
})
export class StandardModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { ApplycourseComponent } from './applycourse/applycourse.component';
import { RegisterUserComponent } from './register-user/register-user.component';
import { RegistercourseComponent } from './registercourse/registercourse.component';
import { AdminComponent } from './standard/admin/admin.component';
import { AddcenterComponent } from './standard/admin/dashboard/center/addcenter/addcenter.component';
import { CenterComponent } from './standard/admin/dashboard/center/center.component';
import { UpdatecenterComponent } from './standard/admin/dashboard/center/updatecenter/updatecenter.component';
import { ViewcenterComponent } from './standard/admin/dashboard/center/viewcenter/viewcenter.component';
import { AddcourseComponent } from './standard/admin/dashboard/course/addcourse/addcourse.component';
import { CourseComponent } from './standard/admin/dashboard/course/course.component';
import { UpdatecourseComponent } from './standard/admin/dashboard/course/updatecourse/updatecourse.component';
import { ViewcourseComponent } from './standard/admin/dashboard/course/viewcourse/viewcourse.component';
import { DashboardComponent } from './standard/admin/dashboard/dashboard.component';
import { AddmanagerComponent } from './standard/admin/dashboard/manager/addmanager/addmanager.component';
import { ManagerComponent } from './standard/admin/dashboard/manager/manager.component';
import { UpdateComponent } from './standard/admin/dashboard/manager/update/update.component';
import { ViewmanagersComponent } from './standard/admin/dashboard/manager/viewmanagers/viewmanagers.component';
import { TeacherComponent } from './standard/admin/dashboard/teacher/teacher.component';
import { UpdateteacherComponent } from './standard/admin/dashboard/teacher/updateteacher/updateteacher.component';
import { ViewteacherComponent } from './standard/admin/dashboard/teacher/viewteacher/viewteacher.component';
import { UpdateuserComponent } from './standard/admin/dashboard/users/updateuser/updateuser.component';
import { UsersComponent } from './standard/admin/dashboard/users/users.component';
import { ViewusersComponent } from './standard/admin/dashboard/users/viewusers/viewusers.component';
import { Center1Component } from './standard/center1/center1.component';
import { Center2Component } from './standard/center2/center2.component';
import { Center3Component } from './standard/center3/center3.component';
import { Center4Component } from './standard/center4/center4.component';
import { Center5Component } from './standard/center5/center5.component';
import { Center6Component } from './standard/center6/center6.component';
import { ViewregisteredcourseComponent } from './standard/courses/viewregisteredcourse/viewregisteredcourse.component';


const routes: Routes = [

  {path:'loginsuccess',component:ApplycourseComponent},
  {path:'login',component:RegisterUserComponent},
  {path:'dashboard',component:DashboardComponent},
  {path:'center1',component:Center1Component},
  {path:'center2',component:Center2Component},
  {path:'center3',component:Center3Component},
  {path:'center4',component:Center4Component},
  {path:'center5',component:Center5Component},
  {path:'center6',component:Center6Component},
  {path:'manager',component:ManagerComponent},
  {path:'center',component:CenterComponent},
  {path:'course',component:CourseComponent},
  {path:'teacher',component:TeacherComponent},
  {path:'user',component:UsersComponent},
  {path:'admin',component:AdminComponent},
  {path:'registercourse',component:RegistercourseComponent},
  {path:'viewregisteredcourse',component:ViewregisteredcourseComponent},
  {path:'viewmanager',component:ViewmanagersComponent},
  {path:'viewmanager/:id',component:ViewmanagersComponent},
  {path:'viewcenter',component:ViewcenterComponent},
  {path:'viewcenter/:id',component:ViewcenterComponent},
  {path:'viewcourse',component:ViewcourseComponent},
  {path:'viewcourse/:id',component:ViewcourseComponent},
  {path:'viewteacher',component:ViewteacherComponent},
  {path:'viewteacher/:id',component:ViewteacherComponent},
  {path:'viewusers',component:ViewusersComponent},
  {path:'viewusers/:id',component:ViewusersComponent},
  {path:'addmanager',component:AddmanagerComponent},
  {path:'addcenter',component:AddcenterComponent},
  {path:'addcourse',component:AddcourseComponent},
  {path:'addteacher',component:AddmanagerComponent},
  {path:'adduser',component:AddmanagerComponent},
  {path:'update',component:UpdateComponent},
  {path:'update/:id',component:UpdateComponent},
  {path:'updatecenter',component:UpdatecenterComponent},
  {path:'updatecenter/:id',component:UpdatecenterComponent},
  {path:'updatecourse',component:UpdatecourseComponent},
  {path:'updatecourse/:id',component:UpdatecourseComponent},
  {path:'updateteacher',component:UpdateteacherComponent},
  {path:'updateteacher/:id',component:UpdateteacherComponent},
  {path:'updateuser',component:UpdateuserComponent},
  {path:'updateuser/:id',component:UpdateuserComponent},
 
];

@NgModule({
  imports: [RouterModule.forRoot(routes, { relativeLinkResolution: 'legacy' })],
  exports: [RouterModule]
})
export class AppRoutingModule { }

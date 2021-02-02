import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Admin, Center, Course, Manager, Teacher, User, Users } from '../modules/user';

@Injectable({
  providedIn: 'root'
})
export class RegistrationService {

  private server: string = 'http://localhost:7071/';
  constructor( private _http : HttpClient) { }

   public loginUserFromRemote(user :User):Observable<User>{
   return this._http.post<User>(this.server+"login",user)


   }
  public registerUserFormRemote(user :User):Observable<User>{
  return this._http.post<User>(this.server+"registeruser",user)

  }
  public loginAdmin(admin :Admin) : Observable<Admin>
{
  return this._http.post<Admin>(this.server+"adminlogin",admin);
}

fetchManagerList(): Observable<Manager[]>
{
  return this._http.get<Manager[]>(this.server+"manager");
}

fetchManagerById(id : string): Observable<Manager>
{
  return this._http.get<Manager>(this.server+"manager/"+id);
}

deleteManagerById(id : number):Observable<any>
{
  return this._http.delete<any>(this.server+"manager/"+ id);
};

addManager( manager : Manager ):Observable<Manager>{
  return this._http.post<Manager>(this.server + "manager",manager);
}

fetchCenterList(): Observable<Center[]>
{
  return this._http.get<Center[]>(this.server+"center");
}

fetchCenterById(id : string): Observable<Center>
{
  return this._http.get<Center>(this.server+"center/"+id);
}

deleteCenterById(id : string):Observable<Center>
{
  return this._http.delete<Center>(this.server+"center/"+ id);
};

addCenter( center : Center ):Observable<any> {
  return this._http.post<any>(this.server+"center",center);
};

updateCenter( id : string, center:Center ):Observable<any> {
  return this._http.put<any>(this.server+"center/update/"+id,center);
};
updateCourse( id : string, course:Course ):Observable<any> {
  return this._http.put<any>(this.server+"course/update/"+id,course);
};
updateTeacher( id : string, teacher:Teacher ):Observable<any> {
  return this._http.put<any>(this.server+"teacher/update/"+id,teacher);
};
updateUsers( id : string, user:User ):Observable<any> {
  return this._http.put<any>(this.server+"user/update/"+id,user);
};

fetchCourseList(): Observable<Course[]>
{
  return this._http.get<Course[]>(this.server+"course");
}

fetchCourseById(id : string): Observable<Course>
{
  return this._http.get<Course>(this.server+"course/"+id);
}

deleteCourseById(id : string):Observable<Course>
{
  return this._http.delete<Course>(this.server+"course/"+ id);
};

addCourse( course : Course ):Observable<Course>{
  return this._http.post<Course>(this.server + "course",course);
}

fetchTeacherList(): Observable<Teacher[]>
{
  return this._http.get<Teacher[]>(this.server+"teacher");
}

fetchTeacherById(id : string): Observable<Teacher>
{
  return this._http.get<Teacher>(this.server+"teacher/"+id);
}

deleteTeacherById(id : string):Observable<Teacher>
{
  return this._http.delete<Teacher>(this.server+"teacher/"+ id);
};

addTeacher( teacher : Teacher ):Observable<Teacher>{
  return this._http.post<Teacher>(this.server + "teacher",teacher);
}

fetchUserList(): Observable<Users[]>
{
  return this._http.get<Users[]>(this.server+"user");
}

fetchUserById(id : string): Observable<Users>
{
  return this._http.get<Users>(this.server+"user/"+id);
}

deleteUserById(id : string):Observable<Users>
{
  return this._http.delete<Users>(this.server+"user/"+ id);
};

addUser( user : User ):Observable<User>{
  return this._http.post<User>(this.server + "user",user);
}

}



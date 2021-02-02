import { StringifyOptions } from "querystring";

export class User {
    id:number;
    email:string;
    name:string;
    password:string;
    contactNumber:string;
    age:number;
    

}
export class Admin {
    id: string;
    email: string;
    password:string;
}
export class Manager {
    id:number;
    firstName:string;
    lastName:string;
    email:string;
    password:string;
    address:string;
    contactNumber:string;
    experience:number;
    
}
export class Center {
    id: number;
    name:string;
    address:string;
    contactNumber:string;
    manager= new Manager();

}
export class Course {
    id: number;
    name:string;
    availability:string;
    beginDate:string;
    endDate:string;
    capacity:string;
    duration:string;
    eligibilityCriteria:string;
    location:string;
    status:string;
    time:string;
    fees:String;
    teacher= new Teacher();
}
export class Teacher {
    id:number;
    name:string;
    email:string;
    contactNumber:string;
    experience:number;
    password:string;
    gender:string;
    disability:string;
    center= new Center();
   
}
export class Users {
    id:number;
    name:string;
    email:string;
    password:string;
    contactNumber:string;
    age:number;
    role:string;
    course= new Course();
}
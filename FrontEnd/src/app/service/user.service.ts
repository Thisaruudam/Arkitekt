import { Injectable } from '@angular/core';
import {User} from "../dtos/user";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

export const MAIN_URL= "http://localhost:8080";
const URL="/api/v1/user";

@Injectable()
export class UserService {

  constructor(private http:HttpClient) { }

  saveUser(user:User):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URL,user);
  }


}

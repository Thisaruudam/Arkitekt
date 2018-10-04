import { Injectable } from '@angular/core';
import {User} from "../dtos/user";
import {Observable} from "rxjs";
import {MAIN_URL} from "./user.service";
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";
import {map} from "rxjs/operators";
import {UserVerify} from "../dtos/userVerify";

const URL= "/api/v1/login";

@Injectable()
export class AuthService {

  constructor(private http:HttpClient,private router:Router) { }

  login(user: User){
    return this.http.post(MAIN_URL + URL, user)
      .pipe(
        map((userVerify:UserVerify)=>{
          if (userVerify!==null){
            sessionStorage.setItem("token",  "true");
            sessionStorage.setItem("email",""+userVerify.email);
            sessionStorage.setItem("isClient",""+userVerify.isClient);

            if(userVerify.isClient.trim()==="true"){
              this.router.navigate(['/main-client']);
              return userVerify;
            }else{
              this.router.navigate(['/main-freelancer']);
              return userVerify;
            }

          }
        })
      )
  }

  isAuthenticated(): boolean{
    if (sessionStorage.getItem("token")){
      return sessionStorage.getItem("token") == 'false' ? false: true;
    }
    return false;
  }

  logout(): void{
    sessionStorage.removeItem("token");
    sessionStorage.removeItem("email");
    sessionStorage.removeItem("client");
    sessionStorage.removeItem("freelancer");
    this.router.navigate(['/login']);
  }
}

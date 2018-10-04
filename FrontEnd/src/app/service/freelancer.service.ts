import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Freelancer} from "../dtos/freelancer";
import {Observable} from "rxjs";
import {MAIN_URL} from "./user.service";
import {Client} from "../dtos/client";

const URL="/api/v1/freeLancer";

@Injectable()
export class FreelancerService {

  constructor(private http:HttpClient) { }

  saveFreeLancer(freeLancer:Freelancer):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URL,freeLancer);
  }

  getFreelancer(email:String):Observable<Freelancer>{
    return this.http.get<Freelancer>(MAIN_URL + URL +"/"+ "?email="+email);
  }

}

import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {NotificationDTO} from "../dtos/notificationDTO";
import {MAIN_URL} from "./user.service";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class NotificationService {

  constructor(private http:HttpClient) { }

  getNotification(freelancerID:string):Observable<Array<NotificationDTO>>{
    return this.http.get<Array<NotificationDTO>>(MAIN_URL+"/api/v1/notify?id="+freelancerID);
  }

}

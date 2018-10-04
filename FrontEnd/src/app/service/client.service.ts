import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MAIN_URL} from "./user.service";
import {Client} from "../dtos/client";

const URL1="/api/v1/clientSave";
const URL2="/api/v1/clientGet";

@Injectable()
export class ClientService {

  constructor(private http:HttpClient) { }

  saveClient(client:Client):Observable<boolean>{
      return this.http.post<boolean>(MAIN_URL+URL1,client);
  }

  getClient(email:String):Observable<Client>{
    return this.http.post<Client>(MAIN_URL + URL2 +"/"+ "?email="+email+"",email);
  }

}

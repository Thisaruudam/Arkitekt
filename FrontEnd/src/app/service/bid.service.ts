import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MAIN_URL} from "./user.service";
import {BidDTO} from "../dtos/bidDTO";
import {ProjectDTO} from "../dtos/projectDTO";

const URL="/api/v1/bid";

@Injectable({
  providedIn: 'root'
})
export class BidService {

  constructor(private http:HttpClient) { }

  placeBid(bid:BidDTO):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URL,bid);
  }

  getBiddedProjects(projectId:string):Observable<Array<BidDTO>>{
    return this.http.get<Array<BidDTO>>(MAIN_URL+URL+ "?projectID="+projectId);
  }

}

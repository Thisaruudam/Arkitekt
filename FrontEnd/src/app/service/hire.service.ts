import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {MAIN_URL} from "./user.service";
import {HireDTO} from "../dtos/hireDTO";

const URL="/api/v1/hire";

@Injectable()
export class HireService {

  constructor(private http: HttpClient) {
  }

  hireFreelancer(hireDTO:HireDTO): Observable<boolean> {
    return this.http.post<boolean>(MAIN_URL + URL,hireDTO);
  }


}

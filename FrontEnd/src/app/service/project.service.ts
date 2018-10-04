import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {ProjectDTO} from "../dtos/projectDTO";
import {Observable} from "rxjs";
import {MAIN_URL} from "./user.service";
import {p} from "@angular/core/src/render3";

const URL="/api/v1/project";
const URL1="/api/v1/getProjects";
const URL2="/api/v1/getProject";

@Injectable()
export class ProjectService {

  constructor(private http:HttpClient) { }

  saveProject(project:ProjectDTO):Observable<boolean>{
    return this.http.post<boolean>(MAIN_URL+URL,project);
  }

  getAllProjects():Observable<Array<ProjectDTO>>{
    return this.http.get<Array<ProjectDTO>>(MAIN_URL+URL);
  }

  getProjects(email:string):Observable<Array<ProjectDTO>>{
    return this.http.get<Array<ProjectDTO>>(MAIN_URL+URL1+"/"+ "?email="+email);
  }

  getProject(projectID:string):Observable<ProjectDTO>{
    return this.http.get<ProjectDTO>(MAIN_URL+URL2+"/"+ "?projectId="+projectID);
  }

}

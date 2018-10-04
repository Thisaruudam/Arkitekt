import { Injectable } from '@angular/core';
import {HttpClient, HttpEvent, HttpRequest} from "@angular/common/http";
import {Observable} from "rxjs";
import {MAIN_URL} from "./user.service";

const URL1="/api/v1/upload";
const URL2="/api/v1/uploadProfilePic";
export const URL3="/api/v1/getProfilePic";
const URL4="/api/v1/getProjectFile";

@Injectable()
export class FileService {

  constructor(private http: HttpClient) {}

  pushFileToStorage(file: File,projectID:string): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    formdata.append('projectID', projectID);
    const req = new HttpRequest('POST', MAIN_URL + URL1, formdata, {
        reportProgress: true,
        responseType: 'text'
      }
    );
    return this.http.request(req);
  }

  uploadProfilePic(file: File): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    formdata.append('email',sessionStorage.getItem("email"));
    const req = new HttpRequest('POST', MAIN_URL + URL2, formdata, {
        reportProgress: true,
        responseType: 'text'
      }
    );
    return this.http.request(req);
  }

  uploadProfilePicS(file: File,email): Observable<HttpEvent<{}>> {
    const formdata: FormData = new FormData();
    formdata.append('file', file);
    formdata.append('email',email);
    const req = new HttpRequest('POST', MAIN_URL + URL2, formdata, {
        reportProgress: true,
        responseType: 'text'
      }
    );
    return this.http.request(req);
  }

  getProjectFiles() {
    var email=sessionStorage.getItem("email");
    return this.http.get(MAIN_URL + URL4 + "?email=" + email);
  }



}

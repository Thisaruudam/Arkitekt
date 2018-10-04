import { Component, OnInit } from '@angular/core';
import {FileUploader} from "ng2-file-upload";
import {MAIN_URL} from "../../../service/user.service";
import swal from "sweetalert";
import {Client} from "../../../dtos/client";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {FileService, URL3} from "../../../service/file-service.service";
import {ClientService} from "../../../service/client.service";
import {DomSanitizer} from '@angular/platform-browser';
import {FileDTO} from "../../../dtos/fileDTO";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponentClient implements OnInit {

  url: any = '../../../../assets/images/users/5.jpg';
  loggedInUser:string="";
  client:Client=new Client();
  selectedFiles: FileList;
  currentFileUpload: File;
  imagesrc:any;
  file:FileReader;
  fileDTO:FileDTO=new FileDTO();
  items = ['Pizza', 'Pasta', 'Parmesan'];


  public uploader:FileUploader = new FileUploader({url: MAIN_URL});

  constructor(private fileService:FileService,private clientService:ClientService,private http:HttpClient,public domSanitizationService: DomSanitizer) {
      this.imagesrc='data:image/jpeg;base64,' + this.domSanitizationService.bypassSecurityTrustResourceUrl(MAIN_URL+URL3);
      // this.url=this._DomSanitizationService.bypassSecurityTrustResourceUrl("http://localhost:8080/api/v1/getProfilePic?email="+this.loggedInUser);
  }

  ngOnInit() {
    this.client=JSON.parse(sessionStorage.getItem("client"));
    this.loggedInUser = sessionStorage.getItem("email");
  }


  readUrl(event: any) {
    this.selectedFiles = event.target.files;
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();
      reader.onload = (event: any) => {
        this.url = event.target.result;
      };

      reader.readAsDataURL(event.target.files[0]);
    }
  }

  upload() {
    this.currentFileUpload = this.selectedFiles.item(0);
    this.fileService.uploadProfilePic(this.currentFileUpload).subscribe(event => {
      if (event instanceof HttpResponse) {
        swal("Successful!", "Your Profile Picture and Data Have Been Uploaded and Updated Successfully!", "success");
        window.location.reload();
      }
    });
    this.selectedFiles = undefined;
  }

  saveClient() {
    this.clientService.saveClient(this.client).subscribe(result => {
      if (result) {
        this.upload();
      } else {
        swal("Failed!", "Please Try Again!", "error");
      }
    });
  }


}

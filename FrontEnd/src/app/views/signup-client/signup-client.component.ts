import { Component, OnInit } from '@angular/core';
import {Client} from "../../dtos/client";
import {User} from "../../dtos/user";
import swal from "sweetalert";
import {UserService} from "../../service/user.service";
import {ClientService} from "../../service/client.service";
import {Router} from "@angular/router";
import {HttpResponse} from "@angular/common/http";
import {FileService} from "../../service/file-service.service";

@Component({
  selector: 'app-signup-client',
  templateUrl: './signup-client.component.html',
  styleUrls: ['./signup-client.component.css']
})
export class SignupClientComponent implements OnInit {

  client:Client=new Client();
  user:User;
  isSelected:boolean=false;
  selectedFiles: FileList;
  currentFileUpload: File;
  url: any = '../../../../assets/images/users/5.jpg';

  constructor(private userService:UserService,private clientService:ClientService,private router:Router,private fileService:FileService) { }

  ngOnInit() {

  }

  saveUser(formData){
    this.user=new User(formData.email,formData.password,"false","true");
    this.userService.saveUser(this.user).subscribe(result=>{
      if(result){
        this.saveClient();
      }else {
        swal("Failed!", "Please Try Again!", "error");
      }
    });
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
    this.fileService.uploadProfilePicS(this.currentFileUpload,this.client.email).subscribe(event => {
      if (event instanceof HttpResponse) {
        swal("Successful!", "You Have Been Registered Successfully!", "success");
      }
    });
    this.selectedFiles = undefined;
  }

  saveClient(){
    this.clientService.saveClient(this.client).subscribe(result=>{
      if(result){
        this.upload();
        this.router.navigate(["/main-client"]);
      }else{
        swal("Failed!", "Please Try Again!", "error");
      }
    });
  }


}

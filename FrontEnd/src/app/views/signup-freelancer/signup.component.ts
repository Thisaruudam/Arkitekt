import { Component, OnInit } from '@angular/core';
import {UserService} from "../../service/user.service";
import {User} from "../../dtos/user";
import swal from 'sweetalert';
import {Router} from "@angular/router";
import {Freelancer} from "../../dtos/freelancer";
import {FreelancerService} from "../../service/freelancer.service";
import {HttpResponse} from "@angular/common/http";
import {FileService} from "../../service/file-service.service";

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent implements OnInit {

  isSelected:boolean=false;
  showDiv:boolean=true;
  freelanacer:Freelancer=new Freelancer();
  user:User;
  selectedFiles: FileList;
  currentFileUpload: File;
  url: any = '../../../../assets/images/users/5.jpg';

  constructor(private userService:UserService,private router:Router,private freelancerService:FreelancerService,private fileService:FileService) { }

  ngOnInit() {
  }

  saveUser(formData){
    this.user=new User(formData.email,formData.password,"false","false");
    this.userService.saveUser(this.user).subscribe(result=>{
      if(result){

        this.saveFreeLancer();
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

      console.log(reader.readAsArrayBuffer(event.target.files[0]));
    }
  }

  upload() {
    this.currentFileUpload = this.selectedFiles.item(0);
    this.fileService.uploadProfilePicS(this.currentFileUpload,this.freelanacer.email).subscribe(event => {
      if (event instanceof HttpResponse) {
        swal("Successful!", "You Have Been Registered Successfully!", "success");
      }
    });
    this.selectedFiles = undefined;
  }

  saveFreeLancer(){
    this.freelancerService.saveFreeLancer(this.freelanacer).subscribe(result=>{
      if(result){
        this.upload();
        this.router.navigate(["/main-freelancer"]);
      }else {
        swal("Failed!", "Please Try Again!", "error");
      }
    });
  }


}

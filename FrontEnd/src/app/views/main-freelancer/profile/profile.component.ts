import { Component, OnInit } from '@angular/core';
import {FileUploader} from "ng2-file-upload";
import {MAIN_URL} from "../../../service/user.service";
import {FreelancerService} from "../../../service/freelancer.service";
import {Freelancer} from "../../../dtos/freelancer";
import swal from "sweetalert";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  url: any = '../../../../assets/images/users/5.jpg';
  showDiv:boolean=true;
  showDivWorker:number=1;
  loggedInUser:string="";
  freelanacer:Freelancer=new Freelancer();

  public uploader:FileUploader = new FileUploader({url: MAIN_URL});

  constructor(private freelancerService:FreelancerService) { }

  ngOnInit() {
    this.loggedInUser = sessionStorage.getItem("email");
    this.freelanacer=JSON.parse(sessionStorage.getItem("freelancer"));
  }


  readUrl(event: any) {
    if (event.target.files && event.target.files[0]) {
      const reader = new FileReader();

      reader.onload = (event: any) => {
        this.url = event.target.result;
      };

      reader.readAsDataURL(event.target.files[0]);

      console.log(reader.readAsArrayBuffer(event.target.files[0]));
    }
  }


  print(x):void{
    console.log(x.range);
  }

  saveFreeLancer(){
    this.freelancerService.saveFreeLancer(this.freelanacer).subscribe(result=>{
      if(result){
        swal("Successful!", "Your Profile Have Been Updated Successfully!", "success");
        // this.router.navigate(["/main"]);
      }else {
        swal("Failed!", "Please Try Again!", "error");
      }
    });
  }

}

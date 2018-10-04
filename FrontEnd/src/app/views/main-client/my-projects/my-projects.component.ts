import { Component, OnInit } from '@angular/core';
import {ProjectDTO} from "../../../dtos/projectDTO";
import {ProjectService} from "../../../service/project.service";
import {DomSanitizer} from "@angular/platform-browser";
import {FileService} from "../../../service/file-service.service";
import {BidDTO} from "../../../dtos/bidDTO";
import {BidService} from "../../../service/bid.service";
import {ButtonList} from "sweetalert/typings/modules/options/buttons";
import {HireService} from "../../../service/hire.service";
import {HireDTO} from "../../../dtos/hireDTO";

@Component({
  selector: 'app-my-projects',
  templateUrl: './my-projects.component.html',
  styleUrls: ['./my-projects.component.css']
})
export class MyProjectsComponent implements OnInit {

  projects:Array<ProjectDTO>=[];
  bids:Array<BidDTO>=[];
  hireDTO:HireDTO=new HireDTO();
  email:string;

  constructor(private projectService:ProjectService,public domSanitizationService: DomSanitizer,private fileService:FileService,private bidService:BidService,private hireService:HireService) { }

  ngOnInit() {
    this.email=sessionStorage.getItem("email");
    this.loadProjects();
  }

  loadProjects(){
    this.projectService.getProjects(this.email).subscribe(result=>{
      this.projects=result;
    });
  }

  loadBids(projectId:string){
    this.bidService.getBiddedProjects(projectId).subscribe(result=>{
      this.bids=result;
    });
  }

  hire(bid:BidDTO){
    this.hireDTO.projectId=bid.projectDTO.projectId;
    this.hireDTO.freelancerId=bid.freeLancerDTO.email;
    swal({
      title: "Are you sure?",
      text: "Once hired, you will not be able to hire another freelancer for this project!",
      icon: "warning",
      buttons: [true, true],
      dangerMode: true,
    })
      .then((willDelete) => {
        if (willDelete) {
          this.hireService.hireFreelancer(this.hireDTO).subscribe(result=>{
            if(result){
              swal("Okay! Your request has been proceed!","We will be notified your freelancer. He/She will be contact you immediately", {
                icon: "success",
              });
              this.loadProjects();
            }else{
              swal("Failed!", "Please Try Again!", "error");
            }
          });
        } else {
          swal("Okay!","Your can hire another one!");
        }
      });
  }

}

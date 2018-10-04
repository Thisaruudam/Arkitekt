import { Component, OnInit } from '@angular/core';
import {ProjectService} from "../../../service/project.service";
import {ProjectDTO} from "../../../dtos/projectDTO";
import {DomSanitizer} from "@angular/platform-browser";
import {BidDTO} from "../../../dtos/bidDTO";
import {BidService} from "../../../service/bid.service";
import swal from "sweetalert";
import {Freelancer} from "../../../dtos/freelancer";

import shortid from "shortid";

@Component({
  selector: 'app-bid',
  templateUrl: './bid.component.html',
  styleUrls: ['./bid.component.css']
})
export class BidComponent implements OnInit {

  projects:Array<ProjectDTO>=[];
  id:any;
  email:any="";
  details:any;
  budget:any;
  bid:BidDTO=new BidDTO();
  freelancer:Freelancer=new Freelancer();
  modalDismiss:boolean=false;
  bids:Array<BidDTO>=[];

  constructor(private projectService:ProjectService,public domSanitizationService: DomSanitizer,private bidService:BidService) { }

  ngOnInit() {
    this.loadProjects();
    shortid.characters('0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ$@');
  }

  loadProjects(){
    this.projectService.getAllProjects().subscribe(result=>{
      this.projects=result;
    });
  }

  setValue(project:ProjectDTO){
    this.id=project.projectId;
    this.email=project.clientDTO.email;
    this.details=project.projectDetails;
    this.budget=project.budget;
    this.bid.projectDTO=project;
  }

  saveBID(){
    this.bid.bidId=shortid.generate();
    this.freelancer=JSON.parse(sessionStorage.getItem("freelancer"));
    this.bid.freeLancerDTO=this.freelancer;
    this.bidService.placeBid(this.bid).subscribe(result=>{
      if(result){
        this.modalDismiss=true;
        swal("Successful!", "Your Bid Have Been Placed Successfully!", "success");
      }else{
        this.modalDismiss=false;
        swal("Failed!", "Please Try Again!", "error");
      }
    });
    this.modalDismiss=false;
  }

  loadBids(projectId:string){
    this.bidService.getBiddedProjects(projectId).subscribe(result=>{
      this.bids=result;
    });
  }

}

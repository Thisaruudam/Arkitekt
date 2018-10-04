import {Component, OnInit} from '@angular/core';
import {DomSanitizer} from "@angular/platform-browser";
import {Client} from "../../../../dtos/client";
import {ClientService} from "../../../../service/client.service";

@Component({
  selector: 'sidebar-client',
  templateUrl: './sidebar.component.html'
})
export class SidebarClientComponent implements OnInit{

  loggedInUser:string="";
  client:Client=new Client();

  constructor(public domSanitizationService: DomSanitizer,private clientService:ClientService){
      this.load();
  }

  ngOnInit(): void {
    this.loggedInUser = sessionStorage.getItem("email");
    this.clientService.getClient(sessionStorage.getItem("email")).subscribe(result=>{
      this.client=result;
      sessionStorage.setItem("client",JSON.stringify(this.client));
    });
  }

  load(){
    this.loggedInUser = sessionStorage.getItem("email");
    // this.client=JSON.parse(sessionStorage.getItem("client"));
  }
	
}

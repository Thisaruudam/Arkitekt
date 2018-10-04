import { Component, OnInit } from '@angular/core';
import {ClientService} from "../../service/client.service";
import {Client} from "../../dtos/client";

@Component({
  selector: 'app-main-client',
  templateUrl: './main-client.component.html',
  styleUrls: ['./main-client.component.css']
})
export class MainClientComponent implements OnInit {

  client:Client=new Client();
  loggedInUser:string="";

  constructor(private clientService:ClientService) { }

  ngOnInit() {

  }

}

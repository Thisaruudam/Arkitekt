import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from "@angular/router";


@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardClientComponent implements OnInit {

  constructor(private route:ActivatedRoute) { }

  ngOnInit() {

  }

}

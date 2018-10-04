import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../../service/auth.service";
import {Freelancer} from "../../../../dtos/freelancer";
import {FreelancerService} from "../../../../service/freelancer.service";
import {NotificationService} from "../../../../service/notification.service";
import {NotificationDTO} from "../../../../dtos/notificationDTO";
import {interval} from "rxjs";

@Component({
  selector: 'navigation-freelancer',
  templateUrl: './navigation.component.html'
})
export class NavigationFreelancerComponent implements OnInit{

  loggedInUser: string;
  freelancer:Freelancer=new Freelancer();
  notifications:Array<NotificationDTO>=new Array<NotificationDTO>();
  showNotify:boolean=false;

  constructor(private authService:AuthService,private freelancerService:FreelancerService,
              private notificationService:NotificationService) {
  }

  ngOnInit(): void {
    this.loggedInUser = sessionStorage.getItem("email");
    this.freelancerService.getFreelancer(sessionStorage.getItem("email")).subscribe(result => {
      this.freelancer = result;
      sessionStorage.setItem("freelancer", JSON.stringify(this.freelancer));
    });

    // interval(1000 * 60 * 10).subscribe(x=>{
      this.notify();
    // });

  }

  logout(){
    this.authService.logout();
  }

  notify(){
    this.notificationService.getNotification(sessionStorage.getItem("email")).subscribe(result=>{
      if(result.length==0){
        this.showNotify=false;
      }else{
        this.notifications=result;
        this.showNotify=true;
      }
    });

    for (let notification of this.notifications) {
      console.log("okay");
      console.log(notification.projectID);
    }

  }

}

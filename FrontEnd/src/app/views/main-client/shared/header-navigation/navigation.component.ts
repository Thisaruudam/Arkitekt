import {Component, OnInit} from '@angular/core';
import {AuthService} from "../../../../service/auth.service";
import {DomSanitizer} from "@angular/platform-browser";
import {Client} from "../../../../dtos/client";
import {ClientService} from "../../../../service/client.service";

@Component({
  selector: 'navigation-client',
  templateUrl: './navigation.component.html'
})
export class NavigationClientComponent implements OnInit {

  loggedInUser: string;
  client: Client = new Client();

  constructor(private authService: AuthService, public domSanitizationService: DomSanitizer, private clientService: ClientService) {
    this.load();
  }

  ngOnInit(): void {
    this.loggedInUser = sessionStorage.getItem("email");
    this.clientService.getClient(sessionStorage.getItem("email")).subscribe(result => {
      this.client = result;
      sessionStorage.setItem("client", JSON.stringify(this.client));
    });
    // this.client = JSON.parse(sessionStorage.getItem("client"));
  }

  load() {
    this.loggedInUser = sessionStorage.getItem("email");
  }

  logout() {
    this.authService.logout();
  }

}

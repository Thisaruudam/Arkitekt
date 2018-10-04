import { Component, OnInit } from '@angular/core';
import {AuthService} from "../../service/auth.service";
import {UserDTO} from "../../dtos/userDTO";
import {UserVerify} from "../../dtos/userVerify";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: UserDTO = new UserDTO();
  userVerify:UserVerify;
  failed: boolean;
  routerLink:String="";

  constructor(private authService:AuthService) { }

  ngOnInit() {
  }

  login(){
    this.authService.login(this.user).subscribe(
      (result)=>{
          if(result==null){
            this.failed=true;
          }
      }
    );
  }

}

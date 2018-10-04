import { Component, OnInit } from '@angular/core';
import Stomp from 'stompjs';
import * as SockJS from 'sockjs-client';
// @ts-ignore
import $ from "jquery";
import {Message} from "../../../dtos/message";

@Component({
  selector: 'app-chat-app',
  templateUrl: './chat-app.component.html',
  styleUrls: ['./chat-app.component.css']
})
export class ChatAppComponent implements OnInit {

  private serverUrl = 'http://localhost:8080/socket'
  private title = 'WebSockets chat';
  private stompClient;
  message1:Message=new Message();

  constructor() {
    this.initializeWebSocketConnection();
  }

  ngOnInit() {
  }

  initializeWebSocketConnection(){
    let ws = new SockJS(this.serverUrl);
    this.stompClient = Stomp.over(ws);
    let that = this;
    this.stompClient.connect({}, function(frame) {
      that.stompClient.subscribe("/chat", (message:Message) => {
        if(message) {
          $(".chat1").append("" +
            "<div class=\"chat-img\"><img src=\"../assets/images/users/1.jpg\" alt=\"user\" /></div>\n" +
            "              <div class=\"chat-content\">\n" +
            "                <h5>James Anderson</h5>\n" +
            "                <div class='box bg-light-info'>"+ message.message + "</div>\n" +
            "              </div>\n" +
            "              <div class=\"chat-time\">"+ message.time +"</div>")
          console.log(message);
        }
      });
    });
  }

  sendMessage(){
    this.stompClient.send("/app/send/message" , {}, this.message1.message);
    // $('#input').val('');
  }

}

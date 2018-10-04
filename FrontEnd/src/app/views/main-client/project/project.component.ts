import {Component, OnInit} from '@angular/core';
import {ProjectDTO} from "../../../dtos/projectDTO";
import {UserDTO} from "../../../dtos/userDTO";
import {ProjectService} from "../../../service/project.service";
import {AuthService} from "../../../service/auth.service";
import {UserService} from "../../../service/user.service";
import {HttpClient, HttpResponse} from "@angular/common/http";
import {FileService} from "../../../service/file-service.service";
import {Client} from "../../../dtos/client";

@Component({
  selector: 'app-project',
  templateUrl: './project.component.html',
  styleUrls: ['./project.component.css']
})
export class ProjectComponent implements OnInit {

  projectDTO: ProjectDTO = new ProjectDTO();
  showDiv: number = 1;
  user: UserDTO = new UserDTO();
  client: Client = new Client();
  failed: boolean;
  skills: any[] = new Array<String>("Experience", "Training Level", "Project Completion", "Charted Architect");

  selectedFiles: FileList;
  currentFileUpload: File;
  imageSrc: string = "../../../../assets/images/backgrounds/bg-2.jpg";

  constructor(private projectService: ProjectService, private authService: AuthService, private userService: UserService,
              private http: HttpClient, private fileService: FileService) {
    this.loadScript();
  }

  ngOnInit() {

  }

  public loadScript() {
    var isFound = false;
    var scripts = document.getElementsByTagName("script")
    for (var i = 0; i < scripts.length; ++i) {
      if (scripts[i].getAttribute('src') != null && scripts[i].getAttribute('src').includes("loader")) {
        isFound = true;
      }
    }

    if (!isFound) {
      var dynamicScripts = ["../../../../assets/plugins/bootstrap-tagsinput/dist/bootstrap-tagsinput.min.js",
        "../../../../assets/js/filedrag.js"];

      for (var i = 0; i < dynamicScripts.length; i++) {
        let node = document.createElement('script');
        node.src = dynamicScripts [i];
        node.type = 'text/javascript';
        node.async = false;
        node.charset = 'utf-8';
        document.getElementsByTagName('head')[0].appendChild(node);
      }

    }
  }

  detectFiles(event) {
    this.selectedFiles = event.target.files;
    let files = event.target.files;
    if (files) {
      for (let file of files) {
        let reader = new FileReader();
        reader.onload = (e: any) => {
          this.imageSrc = e.target.result;
        }
        reader.readAsDataURL(file);
      }
    }
  }

  upload() {
    this.currentFileUpload = this.selectedFiles.item(0);
    this.fileService.pushFileToStorage(this.currentFileUpload, this.projectDTO.projectId).subscribe(event => {
      if (event instanceof HttpResponse) {
        swal("Successful!", "Your Project File Have Been Uploaded Successfully!", "success");
      }
    });
    this.selectedFiles = undefined;
  }

  login() {
    this.user.isAdmin = "false";
    this.authService.login(this.user).subscribe(
      (result) => {
        this.failed = !result;
        this.saveProject();
      }
    );
  }

  saveProject() {

    var skillInString = "";

    for (var skill of this.skills) {
      skillInString = skillInString + skill + ",";
    }

    this.client = JSON.parse(sessionStorage.getItem("client"));
    this.projectDTO.clientDTO = this.client;
    this.projectDTO.requiredSkills = skillInString;

    if (this.showDiv == 1) {
      this.projectDTO.paymentMethod = "Pay Fixed Price";
    } else {
      this.projectDTO.paymentMethod = "Pay By The Hour";
    }


    this.projectService.saveProject(this.projectDTO).subscribe(result => {

      if (result) {
        swal("Successful!", "Your Project Have Been Added Successfully!", "success");
      } else {
        swal("Failed!", "Please Try Again!", "error");
      }

    });

  }


}

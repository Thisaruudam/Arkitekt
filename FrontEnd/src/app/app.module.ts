import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { LandingComponent } from './views/landing/landing.component';
import {AppRoutingModule} from "./app-routing.module";
import { MainFreelancerComponent } from './views/main-freelancer/main-freelancer.component';
import { LoginComponent } from './views/login/login.component';
import { SignupComponent } from './views/signup-freelancer/signup.component';
import { DashboardComponent } from './views/main-freelancer/dashboard/dashboard.component';
import {UserService} from "./service/user.service";
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {ProfileComponent} from './views/main-freelancer/profile/profile.component';
import {AuthGuard} from "./guards/auth.guard";
import {AuthService} from "./service/auth.service";
import {ActivatedRoute, RouterStateSnapshot} from "@angular/router";
import {FileSelectDirective} from "ng2-file-upload";
import {FreelancerService} from "./service/freelancer.service";
import {ProjectService} from "./service/project.service";
import { SignupClientComponent } from './views/signup-client/signup-client.component';
import {ClientService} from "./service/client.service";
import { MainClientComponent } from './views/main-client/main-client.component';
import {DashboardClientComponent} from "./views/main-client/dashboard/dashboard.component";
import {BreadcrumbClientComponent} from "./views/main-client/shared/breadcrumb/breadcrumb.component";
import {BreadcrumbFreelancerComponent} from "./views/main-freelancer/shared/breadcrumb/breadcrumb.component";
import {NavigationClientComponent} from "./views/main-client/shared/header-navigation/navigation.component";
import {NavigationFreelancerComponent} from "./views/main-freelancer/shared/header-navigation/navigation.component";
import {SidebarClientComponent} from "./views/main-client/shared/sidebar/sidebar.component";
import {SidebarFreelancerComponent} from "./views/main-freelancer/shared/sidebar/sidebar.component";
import {ProjectComponent} from "./views/main-client/project/project.component";
import {FileService} from "./service/file-service.service";
import {AngularFileUploaderModule} from "angular-file-uploader";
import { BidComponent } from './views/main-freelancer/bid/bid.component';
import {ProfileComponentClient} from "./views/main-client/client-profile/profile.component";
import {BidService} from "./service/bid.service";
import { MyProjectsComponent } from './views/main-client/my-projects/my-projects.component';
import {ChatAppClientComponent} from './views/main-client/chat-app/chat-app.component';
import {ChatAppComponent} from "./views/main-freelancer/chat-app/chat-app.component";
import { UpdateProjectComponent } from './views/main-client/update-project/update-project.component';
import {TagInputModule} from "ngx-chips";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {HireService} from "./service/hire.service";
import {NotificationService} from "./service/notification.service";

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    MainFreelancerComponent,
    LoginComponent,
    SignupComponent,
    DashboardComponent,
    DashboardClientComponent,
    FileSelectDirective,
    ProjectComponent,
    ProfileComponent,
    ProfileComponentClient,
    SignupClientComponent,
    MainClientComponent,
    BreadcrumbClientComponent,
    BreadcrumbFreelancerComponent,
    NavigationClientComponent,
    NavigationFreelancerComponent,
    SidebarClientComponent,
    SidebarFreelancerComponent,
    BidComponent,
    MyProjectsComponent,
    ChatAppComponent,
    ChatAppClientComponent,
    UpdateProjectComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AngularFileUploaderModule,
    TagInputModule,
    BrowserAnimationsModule,
    ReactiveFormsModule,
    AppRoutingModule
  ],
  providers: [
    UserService,
    AuthGuard,
    AuthService,
    FreelancerService,
    ProjectService,
    ClientService,
    FileService,
    HireService,
    BidService,
    NotificationService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

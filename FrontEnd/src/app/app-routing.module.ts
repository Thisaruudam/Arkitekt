import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {MainFreelancerComponent} from "./views/main-freelancer/main-freelancer.component";
import {LandingComponent} from "./views/landing/landing.component";
import {LoginComponent} from "./views/login/login.component";
import {SignupComponent} from "./views/signup-freelancer/signup.component";
import {DashboardComponent} from "./views/main-freelancer/dashboard/dashboard.component";
import {ProfileComponent} from "./views/main-freelancer/profile/profile.component";
import {AuthGuard} from "./guards/auth.guard";
import {SignupClientComponent} from "./views/signup-client/signup-client.component";
import {DashboardClientComponent} from "./views/main-client/dashboard/dashboard.component";
import {MainClientComponent} from "./views/main-client/main-client.component";
import {ProjectComponent} from "./views/main-client/project/project.component";
import {BidComponent} from "./views/main-freelancer/bid/bid.component";
import {ProfileComponentClient} from "./views/main-client/client-profile/profile.component";
import {MyProjectsComponent} from "./views/main-client/my-projects/my-projects.component";
import {ChatAppComponent} from "./views/main-freelancer/chat-app/chat-app.component";
import {ChatAppClientComponent} from "./views/main-client/chat-app/chat-app.component";
import {UpdateProjectComponent} from "./views/main-client/update-project/update-project.component";


const appRoutes: Routes = [
  {
    path: "",
    component: LandingComponent
  },
  {
    path: "main-freelancer",
    component: MainFreelancerComponent,
    canActivate:[AuthGuard],
    children:[
      {
        path: "freelancer-dashboard",
        component : DashboardComponent
      },
      {
        path: "profile",
        component : ProfileComponent
      },
      {
        path: "bid",
        component : BidComponent
      },
      {
        path: "chat-app-freelancer",
        component : ChatAppComponent
      },
      {
        path: "",
        pathMatch : "full",
        redirectTo: "/main-freelancer/freelancer-dashboard"
      }
    ]
  },

  {
    path: "main-client",
    component: MainClientComponent,
    canActivate:[AuthGuard],
    children:[
      {
        path: "client-dashboard",
        component : DashboardClientComponent
      },
      {
        path: "profile",
        component : ProfileComponentClient
      },
      {
        path: "project",
        component : ProjectComponent
      },
      {
        path: "my-projects",
        component : MyProjectsComponent
      },
      {
        path: "update-project/:id",
        component : UpdateProjectComponent
      },
      {
        path: "chat-app-client",
        component : ChatAppClientComponent
      },
      {
        path: "",
        pathMatch : "full",
        redirectTo: "/main-client/client-dashboard"
      }
    ]
  },

  {
    path: "login",
    component: LoginComponent
  },
  {
    path: "signUp-freelancer",
    component: SignupComponent
  },
  {
    path: "signUp-client",
    component: SignupClientComponent
  }
];

@NgModule({
  imports: [
    RouterModule.forRoot(appRoutes)
  ],
  exports:[
    RouterModule
  ],
  declarations: []
})
export class AppRoutingModule { }

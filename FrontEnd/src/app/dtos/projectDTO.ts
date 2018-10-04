import {Client} from "./client";

export class ProjectDTO {
  projectId:string;
  projectDetails:String;
  requiredSkills:String;
  clientDTO:Client;
  paymentMethod:String;
  duration:String;
  budget:String;
  file:File;
}

import {Freelancer} from "./freelancer";
import {ProjectDTO} from "./projectDTO";

export class BidDTO{
  bidId:string;
  freeLancerDTO:Freelancer;
  projectDTO:ProjectDTO;
  daysToComplete:string;
  amount:number;
}

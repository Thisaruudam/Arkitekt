export class User {
  email:String;
  password:String;
  isAdmin:String;
  isClient:String;

  constructor(email: String, password: String, isAdmin: String, isClient: String) {
    this.email = email;
    this.password = password;
    this.isAdmin = isAdmin;
    this.isClient = isClient;
  }
}

export class Customer {
  id : number;
  name : string;
  email : string;
  pswd: string;
  constructor(id: number, name: string, email: string, pswd:string) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.pswd=pswd;
}
}

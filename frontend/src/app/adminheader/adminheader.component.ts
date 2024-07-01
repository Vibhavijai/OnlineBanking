import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
@Component({
  selector: 'app-adminheader',
  templateUrl: './adminheader.component.html',
  styleUrls: ['./adminheader.component.css']
})
export class AdminheaderComponent implements OnInit {
  username:string | null="";
  isAdmin:boolean=false;
  constructor(private authService: AuthService) { }

  ngOnInit(): void {
    this.username=this.authService.getUsername();
    if(this.username=="Admin"){
      this.isAdmin=true;
    }
  }

}

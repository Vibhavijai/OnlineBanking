import { Component, OnInit } from '@angular/core';
import { AuthService } from '../services/auth.service';
import { AccountsService } from '../services/accounts.service';
@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  userdata:any;
  isAdmin:boolean=false;
  constructor(private authService: AuthService,private accountService: AccountsService) { }

  ngOnInit(): void {
    this.userdata=JSON.parse(sessionStorage.getItem("userData")+"");
    if(sessionStorage.getItem("isAdmin")=="true"){
      this.isAdmin=true;
    }else{
      this.isAdmin=false;
    }
  }

  viewProfile(){
    this.accountService.viewProfile();
  }

    
}

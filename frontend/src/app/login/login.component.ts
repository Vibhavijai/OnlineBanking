import { Component, OnInit } from '@angular/core';
//import { CustomerImpl } from '../model/customer.model'
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { FormsModule } from '@angular/forms'; 
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
 formdata: any;

  constructor(private authService: AuthService, private router: Router) { }
  
  ngOnInit(): void {
    this.formdata= new FormGroup({
      cust_id:new FormControl(),
      pswd:new FormControl()
    })
  }
  onClickSubmit(data: any) {
    
    this.authService.login(data.cust_id,data.pswd).subscribe(
      (response:any) => {
        alert("response received"+response);
        if (response==200) {
          alert("successfully navigated");
          this.router.navigate(['/profile']);
        } else {
          // handle login error
          console.error('Login failed');
        }
      },
      (error:any) => {
        // handle error
        alert("error occured during login");
        console.error('Error occurred during login', error);
      }
    );
    } 
  
}

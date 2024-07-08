import { Component, OnInit } from '@angular/core';
import {FormBuilder, FormGroup, Validators,AbstractControl,ValidationErrors} from "@angular/forms";
import {Customer} from "../model/customer.model";
import {CustomerService} from "../services/customer.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-new-customer',
  templateUrl: './new-customer.component.html',
  styleUrls: ['./new-customer.component.css']
})
export class NewCustomerComponent implements OnInit {
  newCustomerFormGroup! : FormGroup;
  constructor(private fb : FormBuilder, private customerService:CustomerService, private router:Router) { }

  ngOnInit(): void {
    this.newCustomerFormGroup=this.fb.group({
      name : this.fb.control(null, [Validators.required, Validators.minLength(4)]),
      email : this.fb.control(null,[Validators.required, Validators.email]),
      pswd: this.fb.control(null,[Validators.required, this.passwordValidator]),
      confirmPassword:this.fb.control(null,[Validators.required]),
      type: this.fb.control(null,[Validators.required]),
      acc: this.fb.control(null, [Validators.required, Validators.pattern(/^\d{14}$/)]),
      balance: this.fb.control(null,[Validators.required, Validators.min(1000)])
    },{ validator: this.passwordsMatchValidator });

    
  }

  passwordValidator(control: AbstractControl): { [key: string]: boolean } | null {
    const value = control.value;
    if (!value) {
      return null;
    }
    const hasUpperCase = /[A-Z]/.test(value);
    const hasLowerCase = /[a-z]/.test(value);
    const hasNumber = /[0-9]/.test(value);
    const hasSpecialChar = /[!@#$%^&*(),.?":{}|<>]/.test(value);
    const isValidLength = value.length >= 8;

    const passwordValid = hasUpperCase && hasLowerCase && hasNumber && hasSpecialChar && isValidLength;
    return !passwordValid ? { 'passwordStrength': true } : null;
  }

  passwordsMatchValidator(group: AbstractControl): ValidationErrors | null {
    const password = group.get('pswd')?.value;
    const confirmPassword = group.get('confirmPassword')?.value;
    return password === confirmPassword ? null : { 'passwordMismatch': true };
  }

  handleSaveCustomer() {
    let customer:Customer=this.newCustomerFormGroup.value;

    this.customerService.saveCustomerAndBankAccount(customer).subscribe({
        next: data => {
          alert("Customer and bank account have been successfully saved!");
          this.router.navigateByUrl("/customers");
        },
        error: err => {
          console.log(err);
        }
      });


  }
}

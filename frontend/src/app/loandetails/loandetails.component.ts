import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { LoanService } from '../services/loan.service';
import { PaymentsService } from '../services/payments.service';
import { catchError, Observable, throwError } from 'rxjs';
import { AccountDetails } from '../model/account.model';
import {Router} from "@angular/router";
import { JsonPipe } from '@angular/common';

@Component({
  selector: 'app-loandetails',
  templateUrl: './loandetails.component.html',
  styleUrls: ['./loandetails.component.css']
})
export class LoandetailsComponent implements OnInit {
  loans!:Observable<Array<any>>;
  loanFound!:boolean;
  pays!:Observable<Array<any>>;
  loanFormGroup!: FormGroup;
  loanObservable!:Observable<any>;
  errorMessage!: string;
  payViewed: boolean=false;
  constructor(private payService:PaymentsService,private loanService:LoanService,private fb: FormBuilder, private router : Router) { }

  ngOnInit(): void {
    this.handleGetAllLoans();
    
  }

  onSubmit(): void {
    
      this.handleSearchLoans(this.loanFormGroup.value.loanId,this.loanFormGroup.value.planId,this.loanFormGroup.value.typeId,this.loanFormGroup.value.status,this.loanFormGroup.value.minAmount,this.loanFormGroup.value.maxAmount);
    
  }

  handleGetAllLoans(){
    this.loanFormGroup = this.fb.group({
      loanId: this.fb.control(''),
      planId: this.fb.control(''),
      typeId: this.fb.control(''),
      status: this.fb.control(''),
      minAmount: this.fb.control(''),
      maxAmount: this.fb.control('')
    });
    
    this.loans =this.loanService.getAllLoans().pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      })
    );
   // this.loanObservable=this.loans[0];
  }

  handleSearchLoans(loanId:number=0,planId:number=0,typeId:number=0,status:string="",minAmount:number=0,maxAmount:number=100000000) {
    
    this.loans = this.loanService.filterLoans(loanId, planId, typeId,status,minAmount,maxAmount).pipe(
      catchError(err => {
        this.errorMessage = err.message;
        this.loanFound = false;
        return throwError(err);
      })
    );
  }

  handleGetLoanById(loanId:number,amount:number){
    this.loanObservable = this.loanService.getLoanById(loanId,amount).pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      })
    );
    this.loanObservable.subscribe({
      next: (loanDetails) => {
        this.errorMessage = '';
      },
      error: (err) => {
        alert(err);
      }
    });
    this.handleGetPayById(loanId);
  }
  
  handleGetPayById(loanId:number){
    this.pays = this.payService.getPaymentsById(loanId).pipe(
      catchError(err => {
        this.errorMessage = err.message;
        this.loanFound = false;
        return throwError(err);
      })
    );
  }
  showPayments(){
    this.payViewed=true;
  }
  hidePayments(){
    this.payViewed=false;
  }


}

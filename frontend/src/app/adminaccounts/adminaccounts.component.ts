import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { AccountsService } from '../services/accounts.service';
import { CustomerService } from '../services/customer.service';
import { catchError, Observable, throwError } from 'rxjs';
import { AccountDetails } from '../model/account.model';
import {Router} from "@angular/router";

@Component({
  selector: 'app-adminaccounts',
  templateUrl: './adminaccounts.component.html',
  styleUrls: ['./adminaccounts.component.css']
})


export class AdminaccountsComponent implements OnInit {
  accountFormGroup!: FormGroup;
  currentPage: number = 0;
  pageSize: number = 5;
  accountObservable!: Observable<AccountDetails>;
  errorMessage!: string;
  accountFound: boolean = false;
  accounts!:any;

  constructor(private fb: FormBuilder, private accountService: AccountsService, private customerService: CustomerService,private router : Router) { }

  ngOnInit(): void {
    this.accountFormGroup = this.fb.group({
      accountId: this.fb.control('')
    });
    
    this.handleGetAllAccounts();
    
  }

  handleSearchAccount(accountid?:string) {
    let accountId: string;
    if(!accountid){
    accountId= this.accountFormGroup.value.accountId;}
    else{ accountId=accountid;}
    this.accountObservable = this.accountService.getAccount(accountId, this.currentPage, this.pageSize).pipe(
      catchError(err => {
        this.errorMessage = err.message;
        this.accountFound = false;
        return throwError(err);
      })
    );
    this.accountObservable.subscribe({
      next: (accountDetails) => {
        this.accountFound = true;
        this.errorMessage = '';
      },
      error: (err) => {
        this.accountFound = false;
        alert('Invalid accountId');
      }
    });
  }



  handleGetAllAccounts(){
    this.accounts =this.accountService.getAllAccounts().pipe(
      catchError(err => {
        this.errorMessage = err.message;
        return throwError(err);
      })
    );

    /*this.accounts.subscribe({
      next: (accountList) => {
        alert(accountList[0].balance);
        this.errorMessage = '';
      },
      error: (err) => {
        alert('Error during accounts retrieval');
      }
    });*/
  }

  gotoPage(page: number) {
    this.currentPage = page;
    this.handleSearchAccount();
  }

  
}

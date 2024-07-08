import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { environment } from "../../environments/environment";
import { AccountDetails, AccountOperation } from "../model/account.model";
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class AccountsService {
  profileViewed!:boolean;
  constructor(private http: HttpClient) { }

  viewProfile(){
      this.profileViewed=true;
  }
  // Method to fetch account details with pagination
  public getAccount(accountId: string, page: number, size: number): Observable<any> {
    return this.http.get<Array<AccountDetails>>(`${environment.backendHost}/accounts/${accountId}/pageOperations?page=${page}&size=${size}`);
  }

  public getAccountforCustomer(customerid: number): Observable<any> {
    return this.http.get<any>(`${environment.backendHost}/accounts/${customerid}`).pipe(
      map(people => people[0]) // Extract the first element
    );
  }

  public getAccountHistory(accountId: string): Observable<any> {
    return this.http.get(`${environment.backendHost}/accounts/${accountId}/operations`);
  }

  public getAllAccounts(): Observable<any> {
    return this.http.get<any>(`${environment.backendHost}/accounts`);
  }



  // Method for performing a debit operation
  public debit(accountId: string, amount: number, description: string, category: string) {
    const data = { accountId: accountId, amount: amount, description: description, category: category };
    return this.http.post(environment.backendHost + "/accounts/debit", data);
  }

  // Method for performing a credit operation
  public credit(accountId: string, amount: number, description: string) {
    const data = { accountId: accountId, amount: amount, description: description };

    return this.http.post(environment.backendHost+"/accounts/credit", data);
  }

  // Method for performing a transfer operation
  public transfer(accountSource: string, accountDestination: string, amount: number, description: string, category: string) {
    const data = { accountSource, accountDestination, amount, description, category };
    return this.http.post(environment.backendHost + "/accounts/transfer", data);
  }

}

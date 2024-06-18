import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Customer } from '../model/customer.model';
import { environment } from '../../environments/environment';
import { AccountsService } from './accounts.service';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  constructor(
    private http: HttpClient,
    private accountsService: AccountsService
  ) { }

  // Fetch all customers
  public getCustomers(): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${environment.backendHost}/customers`);
  }

  // Search customers by keyword
  public searchCustomers(keyword: string): Observable<Customer[]> {
    return this.http.get<Customer[]>(`${environment.backendHost}/customers/search?keyword=${keyword}`);
  }

  // Save a new customer
  public saveCustomer(customer: Customer): Observable<Customer> {
    return this.http.post<Customer>(`${environment.backendHost}/customers`, customer);
  }

  // Save customer and trigger credit operation
  public saveCustomerAndTriggerCredit(accountId: string, initialAmount: number, description: string): Observable<any> {
    return this.accountsService.credit(accountId, initialAmount, 'Initial amount');
  }

  // Delete a customer by ID
  public deleteCustomer(id: number): Observable<void> {
    return this.http.delete<void>(`${environment.backendHost}/customers/${id}`);
  }

  // Fetch account details using AccountsService
    public getAccount(accountId: string, page: number, size: number): Observable<any> {
      return this.http.get<any>(`${environment.backendHost}/customers/account/${accountId}/transactions?page=${page}&size=${size}`);
    }
}

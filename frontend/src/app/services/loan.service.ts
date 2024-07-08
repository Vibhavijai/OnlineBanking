import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from "@angular/common/http";
import { Observable, max } from "rxjs";
import { environment } from "../../environments/environment";
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class LoanService {

  constructor(private http:HttpClient) { }

  public getAllLoans(): Observable<any> {
    return this.http.get<any>(`${environment.backendHost}/loans/all`);
  }

  public filterLoans(loanId:number,planId:number,typeId:number,status:string,minAmount:number,maxAmount:number): Observable<any> {
    let params = new HttpParams();

    // Add optional parameters to HttpParams if provided
    if (loanId!=0 &&  loanId!=null) {
      params = params.set('loan_id', loanId.toString());
    }
    if (planId!=0 && planId!=null) {
      params = params.set('plan_id', planId.toString());
    }
    if (typeId!=0 && typeId!=null) {
      params = params.set('type_id', typeId.toString());
    }
    if (status!="" && status!=null) {
      params = params.set('status', status);
    }
    if (minAmount!=0 && minAmount!=null) {
      params=params.set('min_amount',minAmount);
    }else{
      params=params.set('min_amount',0);
    }
    if (maxAmount!=0 && maxAmount!=null) {
      params=params.set('max_amount',maxAmount);
    }else{
      params=params.set('max_amount',100000000);
    }
    return this.http.get<any>(`${environment.backendHost}/loans/filterloans`,{params});
  }

  public getLoanById(loanId:number,amount:number): Observable<any> {
    let params = new HttpParams();
    params = params.set('loan_id', loanId.toString());
    params=params.set('min_amount',amount);
    params=params.set('max_amount',amount);
    return this.http.get<any>(`${environment.backendHost}/loans/filterloans`,{params}).pipe(
      map(people => people[0]) // Extract the first element
    );
  }
}

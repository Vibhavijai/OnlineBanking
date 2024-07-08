import { Injectable } from '@angular/core';
import { HttpClient,HttpParams } from "@angular/common/http";
import { Observable, max } from "rxjs";
import { environment } from "../../environments/environment";
import { map } from 'rxjs/operators';


@Injectable({
  providedIn: 'root'
})
export class PaymentsService {

  constructor(private http:HttpClient) { }

  public getPaymentsById(loanId:number): Observable<any> {
    let params = new HttpParams();
    const minDate: Date = new Date(0);
    const maxDate: Date = new Date(8640000000000000);
    params = params.set('loan_id', loanId.toString());
    params=params.set('min_amount',0);
    params=params.set('max_amount',Number.MAX_SAFE_INTEGER);
    params=params.set('start_date',minDate.toString());
    params=params.set('end_date',maxDate.toString());
    return this.http.get<any>(`${environment.backendHost}/pays/filterpays`,{params});
  }

}

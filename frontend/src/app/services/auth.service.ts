import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { FormsModule } from '@angular/forms'; 
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  constructor(private http: HttpClient) {}

  login(cust_id:string, pswd:string): Observable<any> {
    // Replace with your API endpoint
    return this.http.post<any>(`${environment.backendHost}/login`,{cust_id,pswd} );
  }
}

import { Injectable } from '@angular/core';
import { HttpClient, HttpResponse,HttpErrorResponse} from '@angular/common/http';
import { Observable, throwError, BehaviorSubject } from 'rxjs';
import { FormBuilder, FormGroup, Validators,FormControl } from '@angular/forms';
import { FormsModule } from '@angular/forms'; 
import { environment } from '../../environments/environment';
import { map } from 'rxjs/operators';
import { catchError,tap } from 'rxjs/operators';
import { Customer } from '../model/customer.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private tokenKey = 'authToken';
  customer:Customer=new Customer(0,"","","");
  private usernameKey = 'username';
  isAdmin:boolean=false;

  constructor(private http: HttpClient) {}
  
  private loggedIn = new BehaviorSubject<boolean>(this.hasToken());

  login(cust_id:number, pswd:string): Observable<any> {
    // Replace with your API endpoint
    this.customer.id=cust_id;
    this.customer.pswd=pswd;
    return this.http.put<any>(`${environment.backendHost}/login`, this.customer).pipe(
      tap((response) => {
        this.setSession(response.token, response.name);
        this.loggedIn.next(true);
        if(response.name=="Admin"){
          this.isAdmin=true;
        }else{
          this.isAdmin=false;
        }
      }),
      catchError(this.handleError)
    );
  }

  private setSession(token: string, username: string): void {
    localStorage.setItem(this.tokenKey, token);
    localStorage.setItem(this.usernameKey, username);
  }

  logout(): void {
    localStorage.removeItem(this.tokenKey);
    localStorage.removeItem(this.usernameKey);
    this.loggedIn.next(false);
  }

  getToken(): string | null {
    return localStorage.getItem(this.tokenKey);
  }

  getUsername(): string | null {
    return localStorage.getItem(this.usernameKey);
  }

  isLoggedIn(): Observable<boolean> {
    return this.loggedIn.asObservable();
  }

  isanAdmin(): boolean {
    return this.isAdmin;
  }

  private hasToken(): boolean {
    return !!localStorage.getItem(this.tokenKey);
  }


  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'Unknown error occurred';
    if (error.error instanceof ErrorEvent) {
      // Client-side error
      errorMessage = `Error: ${error.error.message}`;
    } else {
      // Backend error
      errorMessage = `Error Code: ${error.status}\nMessage: ${error.message}`;
    }
    console.error(errorMessage);
    return throwError(errorMessage);
  }

}

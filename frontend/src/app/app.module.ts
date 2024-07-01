import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { NavbarComponent } from './navbar/navbar.component';
import { CustomersComponent } from './customers/customers.component';
import { AccountsComponent } from './accounts/accounts.component';
import { NewCustomerComponent } from './new-customer/new-customer.component';
import { CustomerAccountsComponent } from './customer-accounts/customer-accounts.component';
import { HomeComponent } from './home/home.component';
import { CustomerService } from './services/customer.service';
import { AccountsService } from './services/accounts.service';
import { CategoryComponent } from './category/category.component';
import { LoginComponent } from './login/login.component';
import { FooterComponent } from './footer/footer.component';
import { FormsModule } from '@angular/forms';
import { AdminheaderComponent } from './adminheader/adminheader.component';
import { AdminpageComponent } from './adminpage/adminpage.component';



@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    CustomersComponent,
    AccountsComponent,
    NewCustomerComponent,
    CustomerAccountsComponent,
    HomeComponent,
    CategoryComponent,
    LoginComponent,
    FooterComponent,
    AdminheaderComponent,
    AdminpageComponent
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [
    CustomerService,
    AccountsService  // Ensure AccountsService is provided here
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

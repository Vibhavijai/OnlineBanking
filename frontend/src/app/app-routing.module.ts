import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {CustomersComponent} from "./customers/customers.component";
import {AccountsComponent} from "./accounts/accounts.component";
import {HomeComponent} from "./home/home.component";
import {LoginComponent} from "./login/login.component";
import {NewCustomerComponent} from "./new-customer/new-customer.component";
import {CustomerAccountsComponent} from "./customer-accounts/customer-accounts.component";
import { CustomerService } from './services/customer.service';
import { AccountsService } from './services/accounts.service';
import {CategoryComponent} from "./category/category.component";
import {AdminpageComponent} from "./adminpage/adminpage.component";
import {AdminaccountsComponent} from "./adminaccounts/adminaccounts.component";
import { LoandetailsComponent } from './loandetails/loandetails.component';

const routes: Routes = [
  { path :"customers", component : CustomersComponent},
  { path :"accounts", component : AccountsComponent},
  { path :"home", component :HomeComponent},
  { path :"new-customer", component : NewCustomerComponent},
  { path :"customer-accounts/:id", component : CustomerAccountsComponent},
  { path :"category", component : CategoryComponent},
  { path :"", redirectTo : "home", pathMatch: "full"},
  { path :"login", component : LoginComponent},
  { path :"adminpage", component : AdminpageComponent},
  { path :"adminaccounts", component : AdminaccountsComponent},
  { path :"loandetails", component : LoandetailsComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

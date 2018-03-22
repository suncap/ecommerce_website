import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { MaterialModule } from './material.module';
import { routing } from './app.routing';

import 'hammer.js';
import { DataTableModule } from 'angular2-datatable';
import { DataFilterPipe } from './components/book-list/data-filter.pipe';

import {LoginService} from './services/login.service';
import {UserService} from './services/user.service';
import {PaymentService} from './services/payment.service';
import {ShippingService} from './services/shipping.service';
import {BookService} from './services/book.service';

import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { MyProfileComponent } from './components/my-profile/my-profile.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    NavBarComponent,
    DataFilterPipe
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    DataTableModule
  ],
  providers: [LoginService,UserService,PaymentService,ShippingService,BookService],
  bootstrap: [AppComponent]
})
export class AppModule { }

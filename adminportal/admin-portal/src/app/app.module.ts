import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';
import { routing } from './app.routing';
import { MaterialModule } from './material.module';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';

import 'hammerjs';

import { LoginService } from './services/login.service';
import { AddBookService } from './services/add-book.service';
import { UploadFileService } from './services/upload-file.service';

import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { AddnewbookComponent } from './components/addnewbook/addnewbook.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    NavBarComponent,
    AddnewbookComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    routing,
    MaterialModule,
    BrowserAnimationsModule
  ],
  providers: [
    LoginService,
    AddBookService,
    UploadFileService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

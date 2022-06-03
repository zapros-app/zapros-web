import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotFoundComponent } from './component/not-found/not-found.component';
import {HttpClientModule} from "@angular/common/http";
import {BackendService} from "./service/backend.service";
import { MainHeaderComponent } from './component/main-header/main-header.component';
import { ProjectComponent } from './component/project/project.component';
import { ProjectOneComponent } from './component/project-one/project-one.component';
import { RegisterUserComponent } from './component/register-user/register-user.component';
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AskComponent } from './component/ask/ask.component';
import { CheckValidComponent } from './component/check-valid/check-valid.component';

@NgModule({
  declarations: [
    AppComponent,
    NotFoundComponent,
    MainHeaderComponent,
    ProjectComponent,
    ProjectOneComponent,
    RegisterUserComponent,
    AskComponent,
    CheckValidComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [
    BackendService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

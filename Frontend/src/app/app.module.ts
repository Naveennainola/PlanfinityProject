import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http'; // Import HttpClientModule for HTTP requests
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { HomeComponent } from './home/home.component';
import { CarouselcontComponent } from './home/cardscont/carouselcont/carouselcont.component';
import { CardscontComponent } from './home/cardscont/cardscont.component';
import { WhyattendeventsComponent } from './home/whyattendevents/whyattendevents.component';
import { EventinfoComponent } from './home/eventinfo/eventinfo.component';
import { EventFormComponent } from './event-form/event-form.component';
import { FormsModule } from '@angular/forms';
import { RegisterComponent } from './register/register.component';
import { LoginComponent } from './login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations'; // Import FormsModule for template-driven forms
import { MatSnackBarModule } from '@angular/material/snack-bar'; // Import MatSnackBarModule for snack bar notifications;

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    AboutusComponent,
    ContactusComponent,
    HomeComponent,
    CarouselcontComponent,
    CardscontComponent,
    WhyattendeventsComponent,
    EventinfoComponent,
    EventFormComponent,
    RegisterComponent,
    LoginComponent
  ],
  imports: [
    FormsModule, // Import FormsModule to use ngModel for two-way data binding
    HttpClientModule,
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

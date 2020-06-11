import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AlertsModule } from 'angular-alert-module';
import { HomeComponent } from './components/home/home.component';
import { UpdateEventComponent } from './components/update-event/update-event.component';
import { CreateNewEventComponent } from './components/create-new-event/create-new-event.component';
import { AuthorisedTopNavComponent } from './layout/authorised/authorised-top-nav/authorised-top-nav.component';
import { AuthorisedSideNavTogglerComponent } from './layout/authorised/authorised-side-nav-toggler/authorised-side-nav-toggler.component';
import { AuthorisedLayoutComponent } from './layout/authorised/authorised-layout/authorised-layout.component';
import { AuthorisedSideNavComponent } from './layout/authorised/authorised-side-nav/authorised-side-nav.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { myfilterPipe } from './components/home/event-filter.pipe';
import { ProfileComponent } from './components/profile/profile.component';
import { AdminComponent } from './components/admin/admin.component';
import { AdminUpdateArtistEventComponent } from './components/admin-update-artist-event/admin-update-artist-event.component';
import { AuditionComponent } from './components/audition/audition.component';
import { ConcertComponent } from './components/concert/concert.component';
import { ShowComponent } from './components/show/show.component';
import { FirstPageComponent } from './components/first-page/first-page.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    UpdateEventComponent,
    CreateNewEventComponent,
    AuthorisedTopNavComponent,
    AuthorisedSideNavTogglerComponent,
    AuthorisedLayoutComponent,
    AuthorisedSideNavComponent,
    myfilterPipe,
    ProfileComponent,
    AdminComponent,
    AdminUpdateArtistEventComponent,
    AuditionComponent,
    ConcertComponent,
    ShowComponent,
    FirstPageComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    AlertsModule.forRoot(),
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SubscribeComponent } from './components/subscribe/subscribe.component';
import { CreateNewEventComponent } from './components/create-new-event/create-new-event.component';
import { UpdateEventComponent } from './components/update-event/update-event.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AdminComponent } from './components/admin/admin.component';
import { AdminUpdateArtistEventComponent } from './components/admin-update-artist-event/admin-update-artist-event.component';
import { AuditionComponent } from './components/audition/audition.component';
import { ConcertComponent } from './components/concert/concert.component';
import { ShowComponent } from './components/show/show.component';



const routes: Routes = [
  {path : '', redirectTo:'/login', pathMatch:'full' },
  {path:'home', component : HomeComponent},
  {path:'login', component : LoginComponent},
  {path: 'subscribe', component : SubscribeComponent},
  {path:'createNewEvent', component : CreateNewEventComponent},
  {path:'update/:idEvent',component : UpdateEventComponent},
  {path:'profile/:id',component:ProfileComponent},
  {path:'admin',component:AdminComponent},
  {path:'logout',component : LoginComponent},
  {path:'adminUpdate/:idEvent',component : AdminUpdateArtistEventComponent},
  {path:'audition',component : AuditionComponent},
  {path:'concert',component : ConcertComponent},
  {path:'show',component : ShowComponent}
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

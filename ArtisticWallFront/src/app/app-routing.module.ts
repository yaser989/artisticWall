import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { CreateNewEventComponent } from './components/create-new-event/create-new-event.component';
import { UpdateEventComponent } from './components/update-event/update-event.component';
import { ProfileComponent } from './components/profile/profile.component';
import { AdminComponent } from './components/admin/admin.component';
import { AdminUpdateArtistEventComponent } from './components/admin-update-artist-event/admin-update-artist-event.component';
import { AuditionComponent } from './components/audition/audition.component';
import { ConcertComponent } from './components/concert/concert.component';
import { ShowComponent } from './components/show/show.component';
import { FirstPageComponent } from './components/first-page/first-page.component';



const routes: Routes = [
  {path : '', redirectTo:'/firstPage', pathMatch:'full' },
  {path:'home', component : HomeComponent},
  {path:'createNewEvent', component : CreateNewEventComponent},
  {path:'update/:idEvent',component : UpdateEventComponent},
  {path:'profile/:id',component:ProfileComponent},
  {path:'admin/:id',component:AdminComponent},
  {path:'logout',component : FirstPageComponent},
  {path:'adminUpdate/:idEvent',component : AdminUpdateArtistEventComponent},
  {path:'audition',component : AuditionComponent},
  {path:'concert',component : ConcertComponent},
  {path:'show',component : ShowComponent},
  {path:'firstPage',component : FirstPageComponent}
 
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

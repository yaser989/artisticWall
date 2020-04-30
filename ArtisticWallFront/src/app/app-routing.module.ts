import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SubscribeComponent } from './components/subscribe/subscribe.component';
import { CreateNewEventComponent } from './components/create-new-event/create-new-event.component';
import { UpdateEventComponent } from './components/update-event/update-event.component';
import { ProfileComponent } from './components/profile/profile.component';



const routes: Routes = [
  {path : '', redirectTo:'/login', pathMatch:'full' },
  {path:'home', component : HomeComponent},
  {path:'login', component : LoginComponent},
  {path: 'subscribe', component : SubscribeComponent},
  {path:'createNewEvent', component : CreateNewEventComponent},
  {path:'update/:id',component : UpdateEventComponent},
  {path:'profile/:id',component:ProfileComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

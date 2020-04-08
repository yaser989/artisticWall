import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent } from './components/login/login.component';
import { SubscribeComponent } from './components/subscribe/subscribe.component';



const routes: Routes = [
  {path : '', redirectTo:'/login', pathMatch:'full' },
  {path:'home', component : HomeComponent},
  {path:'login', component : LoginComponent},
  {path: 'subscribe', component : SubscribeComponent}

];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

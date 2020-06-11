import { Component, OnInit } from '@angular/core';
import { AuthorisedSideNavService } from '../services/authorised-side-nav.service';
import {Artist} from 'src/app/models/artist';
import { Router } from '@angular/router';
import {EventService} from 'src/app/services/event/event.service';
import { ArtistDto } from 'src/app/models/artistDto';
import {ArtistService} from 'src/app/services/artist/artist.service';
import { AdminDto } from 'src/app/models/adminDto';
import { EventDto } from 'src/app/models/eventDto';
@Component({
  selector: 'app-authorised-side-nav',
  templateUrl: './authorised-side-nav.component.html',
  styleUrls: ['./authorised-side-nav.component.css']
})
export class AuthorisedSideNavComponent implements OnInit {
  artist : ArtistDto;
  artiste : Artist;
  event : EventDto;
  isAdmin:boolean=false;
  adminDto : AdminDto;
  constructor(public sideNavService: AuthorisedSideNavService,private router :Router,private eventService : EventService ,private artistService :ArtistService) { 
    this.checkUser();
    
  }

  ngOnInit(): void {
  }
  checkUser(){
    if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null){
      this.router.navigate(['/firstPage']);
      return;
    }
    this.artist = JSON.parse(localStorage.getItem('currentUser'));

    if (this.artist.artistRole.match('ROLE_ADMIN')){
      this.isAdmin = true;
    }
    else {
      this.isAdmin = false;
    }
  }

  addNewEvent(){
    let idDto = localStorage.getItem('currentUser');
    this.eventService.findAllArtistEvent(this.artist.id)
    .subscribe(data => this.artist.id, err => console.log(err));
    this.router.navigate(['/createNewEvent']);
  }
  goToHome(){
    this.router.navigate(['/home']);
  }
  profile(id: number){
    this.router.navigate(['/profile',id]);
  }
   logout(){
   this.artistService.logout()   
  localStorage.clear();
  window.location.reload();
  
   }
   
   admin(id:number){
    
    this.router.navigate(['/admin',id]);
   }
   
   
}

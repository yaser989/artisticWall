import { Component, OnInit } from '@angular/core';
import { AuthorisedSideNavService } from '../services/authorised-side-nav.service';
import {Artist} from 'src/app/models/artist';
import { Router } from '@angular/router';
import {EventService} from 'src/app/services/event/event.service';
import { ArtistDto } from 'src/app/models/artistDto';
import {ArtistService} from 'src/app/services/artist/artist.service';
@Component({
  selector: 'app-authorised-side-nav',
  templateUrl: './authorised-side-nav.component.html',
  styleUrls: ['./authorised-side-nav.component.css']
})
export class AuthorisedSideNavComponent implements OnInit {
  artist : ArtistDto;
  artiste : Artist;
  constructor(public sideNavService: AuthorisedSideNavService,private router :Router,private eventService : EventService ,private artistService :ArtistService) { 
    this.checkUser();
    
  }

  ngOnInit(): void {
  }
  checkUser(){
    if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null){
      this.router.navigate(['/login']);
      return;
    }
    this.artist = JSON.parse(localStorage.getItem('currentUser'));
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
   .subscribe(data => {
     sessionStorage.removeItem('currentUser')
     this.artiste.mail = null
     this.artiste.password = null
   
   });
   this.router.navigate(['/login']);
   }
}

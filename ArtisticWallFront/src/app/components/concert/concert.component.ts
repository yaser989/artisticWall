import { Component, OnInit } from '@angular/core';
import { Artist } from 'src/app/models/artist';
import { EventDto } from 'src/app/models/eventDto';
import { EventService } from 'src/app/services/event/event.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import {ArtistService} from 'src/app/services/artist/artist.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-concert',
  templateUrl: './concert.component.html',
  styleUrls: ['./concert.component.css']
})
export class ConcertComponent implements OnInit {
  artist :Artist ; 
  evente : EventDto [];
  
 events : Event;
  constructor(private eventService:EventService,private router :Router ) {
    this.checkUser();
   }

  ngOnInit(): void {
    this.findEventByCocert();
   
  }
  
  filter(keyWord: string){
    if(keyWord === undefined || keyWord.length === 0){
      this.findEventByCocert();
      return;
    }
    this.evente = this.evente.filter(data => 
  data.categoriesDto.toLocaleLowerCase().includes(keyWord) 
      
      );
  }
  
  
  
    checkUser(){
      if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null){
        this.router.navigate(['/login']);
        return;
      }
      this.artist = JSON.parse(localStorage.getItem('currentUser'));
    }
  
    findEventByCocert(){
      this.eventService.getEventByConcert().subscribe(data => {
        this.evente = data
      });
    }
  
    shareEvent(idEvent : number, shared: boolean){
    this.eventService.shareEvent(idEvent,shared)
    .pipe()
    .subscribe(data => {
      this.findEventByCocert();
    });
    window.location.reload();
    }
  
}

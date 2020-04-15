import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Artist} from 'src/app/models/artist';
import { EventService } from 'src/app/services/event/event.service';
import { Event } from 'src/app/models/event';
import { EventDto } from 'src/app/models/eventDto';
import { ArtistDto } from 'src/app/models/artistDto';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  artist :Artist ; 
  event : EventDto[];
  constructor(private router :Router, private eventService:EventService  ) {
    this.checkUser();
    
   }

  ngOnInit(): void {
    this.findAllEvent();
  }


/**filter(keyWord: string){
  if(keyWord === undefined || keyWord.length === 0){
    this.findAllEvent();
    return;
  }
  this.event = this.event.filter(event => 
    event.categoriesDto.toLocaleLowerCase().includes(keyWord) || event.typeEventDto.toLocaleLowerCase().includes(keyWord));
}*/



  checkUser(){
    if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null){
      this.router.navigate(['/login']);
      return;
    }
    this.artist = JSON.parse(localStorage.getItem('currentUser'));
  }

  findAllEvent(){
    this.eventService.findAllArtistEvent(this.artist.id)
    .pipe()
    .subscribe(data => {
      this.event = data;
    }, error => {
      console.log(error);
    });
  }

  shareEvent(id : number, shared : boolean){
  this.eventService.shareEvent(id,shared)
  .pipe()
  .subscribe(data => {
    this.findAllEvent();
  });
  }


  

}

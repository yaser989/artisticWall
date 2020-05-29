import { Component, OnInit } from '@angular/core';
import { Artist } from 'src/app/models/artist';
import { EventDto } from 'src/app/models/eventDto';
import { EventService } from 'src/app/services/event/event.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import {ArtistService} from 'src/app/services/artist/artist.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-audition',
  templateUrl: './audition.component.html',
  styleUrls: ['./audition.component.css']
})
export class AuditionComponent implements OnInit {
  artist :Artist ; 
  evente : EventDto [];
  
 events : Event;
  constructor(private eventService:EventService,private router :Router ) { 
    this.checkUser();
  }

  ngOnInit(): void {
  this.findEventByAudition();
  }


  filter(keyWord: string){
    if(keyWord === undefined || keyWord.length === 0){
      this.findEventByAudition();
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
  
    findEventByAudition(){
      this.eventService.getEventByAudition().subscribe(data => {
        this.evente = data
      });
  
    }
  
    shareEvent(idEvent : number, shared: boolean){
    this.eventService.shareEvent(idEvent,shared)
    .pipe()
    .subscribe(data => {
      this.findEventByAudition();
    });
    window.location.reload();
    }
  
    public  check : boolean ;
    nameButton : String = "see more..";
     myClick  ()  { 
       this.check =! this.check;
       if (this.check){
         this.nameButton = "see less";
       }
   else{
     this.nameButton = "see more..";
   }
   
     }
}

import { Component, OnInit } from '@angular/core';
import { Artist } from 'src/app/models/artist';
import { EventDto } from 'src/app/models/eventDto';
import { EventService } from 'src/app/services/event/event.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import {ArtistService} from 'src/app/services/artist/artist.service';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-show',
  templateUrl: './show.component.html',
  styleUrls: ['./show.component.css']
})
export class ShowComponent implements OnInit {
  artist :Artist ; 
  evente : EventDto [];
  typeEvent : any;
 events : Event;
  constructor(private eventService:EventService,private router :Router,private route : ActivatedRoute ) { 
    this.checkUser();
  }

  ngOnInit(): void {
    this.findEventByShow();
   
  }
  
  filter(keyWord: string){
    if(keyWord === undefined || keyWord.length === 0){
      this.findEventByShow();
      return;
    }
    this.evente = this.evente.filter(data => 
  data.categoriesDto.toLocaleLowerCase().includes(keyWord) 
      
      );
  }
  
  
  
    checkUser(){
      if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null){
        this.router.navigate(['/firstPage']);
        return;
      }
      this.artist = JSON.parse(localStorage.getItem('currentUser'));
    }
  
    findEventByShow(){
      this.eventService.getEventByShow().subscribe(data => {
        this.evente = data
      });
    }
  
    shareEvent(idEvent : number, shared: boolean){
    this.eventService.shareEvent(idEvent,shared)
    .pipe()
    .subscribe(data => {
      this.findEventByShow();
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

     getUrl()
     {
       return "url('assets/R10962_image1.jpg')";
     }
}

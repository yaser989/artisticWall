import { Component, OnInit } from '@angular/core';
import {Artist} from 'src/app/models/artist';
import { Router } from '@angular/router';
import { EventService } from 'src/app/services/event/event.service';
import { ArtistDto } from 'src/app/models/artistDto';
import { EventDto } from 'src/app/models/eventDto';
import {FormGroup, FormControl, Validators} from '@angular/forms';
@Component({
  selector: 'app-create-new-event',
  templateUrl: './create-new-event.component.html',
  styleUrls: ['./create-new-event.component.css']
})
export class CreateNewEventComponent implements OnInit {
  artist : Artist;
  event : EventDto = new EventDto ();
  eventForm : FormGroup;
  constructor(private router :Router,private eventService : EventService) {
    this.checkUser();
   }

  ngOnInit(): void {
this.eventForm = new FormGroup({
  typeEventDto : new FormControl ('',Validators.required),
  descriptionDto : new FormControl ('',Validators.required),
  categoriesDto :new FormControl ('',Validators.required),
  streetDto : new FormControl ('',Validators.required),
  zipCodeDto : new FormControl ('',Validators.required),
  commonDto :new FormControl ('',Validators.required),
  phoneDto : new FormControl ('',Validators.required),
  dateDto : new FormControl ('',Validators.required)
});
  }

  checkUser(){
    if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null){
      this.router.navigate(['/login']);
      return;
    }
    this.artist = JSON.parse(localStorage.getItem('currentUser'));
  }

  createEvent(){
    this.eventService.createNewEvent(this.event,this.artist.id).subscribe (data => {
      this.event = data
      console.log(this.event)
      console.log(this.artist.id)
    });
    this.router.navigate(['/home']);
  }

}

import { Component, OnInit } from '@angular/core';
import { EventService } from 'src/app/services/event/event.service';
import { EventDto } from 'src/app/models/eventDto';
import { ActivatedRoute, Router } from '@angular/router';
import {Event} from 'src/app/models/event';
@Component({
  selector: 'app-update-event',
  templateUrl: './update-event.component.html',
  styleUrls: ['./update-event.component.css']
})
export class UpdateEventComponent implements OnInit {
  event : Event = new Event ();
  evente : EventDto  = new EventDto();
  idEvent:number;
  constructor(private route : ActivatedRoute, private router: Router,private eventService:EventService) { }

  ngOnInit(): void {
   
    this.idEvent = this.route.snapshot.params.idEvent;
    this.eventService.findEventByID(this.idEvent)
    .subscribe(data => {
      this.evente = data
      console.log(this.evente);
    });
    

  }


  updateEvent(){
    this.eventService.updateEvent(this.evente,this.idEvent)
    .subscribe(data => {
      this.evente = data;
    }); 
    this.router.navigate(['/home']);
  }
}

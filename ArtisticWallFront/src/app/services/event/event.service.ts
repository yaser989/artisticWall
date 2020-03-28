import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {AppSitings} from 'src/app/settings/app.sittings';
import {Event} from 'src/app/models/event';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {

  constructor(private http : HttpClient) { }

  findAllEvent(){
    return this.http.get<Event>(AppSitings.App_URL+"/event/")
  }

  findAllArtistEvent(id:number){
    return this.http.get<Event[]>(AppSitings.App_URL+"/event/"+id)
  }

  createNewEvent(event: Event, id : number){
    return this.http.post<Event>(AppSitings.App_URL+"/event/create/" +id ,event)
  }

  shareEvent(id:number, isShared:boolean){
    return this.http.get<Event>(AppSitings.App_URL+"/event/share"+id+"/"+isShared)
  }
deleteEvent(id:number){
  return this.http.delete<Event>(AppSitings.App_URL+"/event/"+id)
}

updateEvent(id:number, event:Event){
  return this.http.put<Event>(AppSitings.App_URL+"/event/update/"+id,event)
}

}

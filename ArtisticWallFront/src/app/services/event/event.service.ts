import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpEvent, HttpRequest } from '@angular/common/http';
import {AppSitings} from 'src/app/settings/app.sittings';
import {Event} from 'src/app/models/event';
import { EventDto } from 'src/app/models/eventDto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EventService {
  
  public require: any
  constructor(private http : HttpClient) { }

  findAllEvent(){
    return this.http.get<EventDto>(AppSitings.App_URL+"/event/")
  }

  findAllArtistEvent(idEvent:number) { 
    return this.http.get<EventDto []>(AppSitings.App_URL+"/event/"+idEvent)
  }

  findEventByID(idEvent : number): Observable<any>{
   return this.http.get(AppSitings.App_URL+"/event/findByID/"+idEvent);
  }

  createNewEvent(event: EventDto, idEvent : number){
    return this.http.post<EventDto>(AppSitings.App_URL+"/event/create/" +idEvent ,event)
  }

  shareEvent(idEvent:number, isShared:boolean){
    return this.http.get<EventDto>(AppSitings.App_URL+"/event/share/"+idEvent+"/"+isShared)
  }
deleteEvent(idEvent:number) : Observable<any>{
  return this.http.delete(AppSitings.App_URL+"/event/"+idEvent)
}

updateEvent(event:EventDto,idEvent:number) : Observable<any>{
  return this.http.put(AppSitings.App_URL+"/event/update/"+idEvent,event)
}

uploadProductPhoto(file: File, idEvent :number): Observable<HttpEvent<{}>> {
  let formatData: FormData = new FormData();
  formatData.append('file', file);
  const req = new HttpRequest('POST',AppSitings.App_URL+ "/photos/uploadPhoto/" + idEvent , formatData, {
    reportProgress: true,
    responseType: 'text'
  });
  return this.http.request(req);
  
}

getEventByAudition() :Observable<any>{
return this.http.get(AppSitings.App_URL+"/event/Audition")
}
getEventByConcert() :Observable<any>{
  return this.http.get(AppSitings.App_URL+"/event/Concert")
}
getEventByShow() :Observable<any>{
  return this.http.get(AppSitings.App_URL+"/event/Show")
}
}

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

  findAllArtistEvent(id:number) : Observable<any> { 
    return this.http.get(AppSitings.App_URL+"/event/"+id)
  }

  createNewEvent(event: EventDto, id : number){
    return this.http.post<EventDto>(AppSitings.App_URL+"/event/create/" +id ,event)
  }

  shareEvent(id:number, isShared:boolean){
    return this.http.get<Event>(AppSitings.App_URL+"/event/share"+id+"/"+isShared)
  }
deleteEvent(id:number) : Observable<any>{
  return this.http.delete(AppSitings.App_URL+"/event/"+id)
}

updateEvent(id:number, event:Event){
  return this.http.put<Event>(AppSitings.App_URL+"/event/update/"+id,event)
}

uploadProductPhoto(file: File, id :number): Observable<HttpEvent<{}>> {
  let formatData: FormData = new FormData();
  formatData.append('file', file);
  const req = new HttpRequest('POST',AppSitings.App_URL+ "/photos/uploadPhoto/" + id , formatData, {
    reportProgress: true,
    responseType: 'text'
  });
  return this.http.request(req);
  
}


}

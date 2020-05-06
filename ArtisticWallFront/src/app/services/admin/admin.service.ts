import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpEvent, HttpRequest } from '@angular/common/http';
import {AppSitings} from 'src/app/settings/app.sittings';
import { Observable } from 'rxjs';
import { AdminDto } from 'src/app/models/adminDto';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http : HttpClient) { }

AdminFindAll(){
  return this.http.get<AdminDto []>(AppSitings.App_URL+"/admin/");
}

findAllByID(idEvent : number): Observable<any>{
  return this.http.get(AppSitings.App_URL+"/admin/findByID/"+idEvent);
 }

deleteEvent(id:number) : Observable<any>{
  return this.http.delete(AppSitings.App_URL+"/admin/"+id)
}

adminUpdateArtistEvent(admin:AdminDto,idEvent:number) : Observable<any>{
  return this.http.put(AppSitings.App_URL+"/admin/update/"+idEvent,admin)
}
}

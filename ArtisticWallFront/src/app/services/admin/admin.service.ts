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

}

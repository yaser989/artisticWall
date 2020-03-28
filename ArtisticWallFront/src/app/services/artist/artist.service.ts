import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import {AppSitings} from 'src/app/settings/app.sittings';
import {Artist} from 'src/app/models/artist';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  constructor(private http:HttpClient) { }


findAllArtist(){
  return this.http.get<Artist>(AppSitings.App_URL+"/artist/")
}

findArtistById(id : number){
  return this.http.get<Artist>(AppSitings.App_URL+"/artist/" + id)
}
createNewArtist(artist : Artist){
  return this.http.post<Artist>(AppSitings.App_URL+"/artist/",artist)
}
login(mail: string, password: string){
  return this.http.post<Artist>(AppSitings.App_URL+"/artist/login?mail="+mail+"&password="+password,null)
}

}

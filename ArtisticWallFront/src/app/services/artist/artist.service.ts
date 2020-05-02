import { Injectable } from '@angular/core';
import { HttpClient, HttpParams, HttpRequest, HttpEvent } from '@angular/common/http';
import {AppSitings} from 'src/app/settings/app.sittings';
import {Artist} from 'src/app/models/artist';
import {ArtistDto} from 'src/app/models/artistDto';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ArtistService {

  constructor(private http:HttpClient) { }


findAllArtist(){
  return this.http.get<Artist>(AppSitings.App_URL+"/artist/")
}

findArtistById(id : number)  : Observable<any>{
  return this.http.get(AppSitings.App_URL+"/artist/" + id)
}
createNewArtist(artist : ArtistDto){
  return this.http.post<ArtistDto>(AppSitings.App_URL+"/artist/",artist)
}

updateArtist(artist:ArtistDto,id:number) : Observable<any>{
  return this.http.put(AppSitings.App_URL+"/artist/update/"+id,artist)
}


login(mail: string, password: string){
  return this.http.post<Artist>(AppSitings.App_URL+"/artist/login?mail="+mail+"&password="+password,null)
}

uploadProductPhoto(file: File, id :number): Observable<HttpEvent<{}>> {
  let formatData: FormData = new FormData();
  formatData.append('file', file);
  const req = new HttpRequest('POST',AppSitings.App_URL+ "/photos/uploadPhotoArtist/" + id , formatData, {
    reportProgress: true,
    responseType: 'text'
  });
  return this.http.request(req);
  
}

logout(){
  return this.http.get(AppSitings.App_URL+"/artist/logoutSuccessful");
}

}

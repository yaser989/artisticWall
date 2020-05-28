import { Component, OnInit } from '@angular/core';
import {Artist} from 'src/app/models/artist';
import { Router } from '@angular/router';
import {ArtistService} from 'src/app/services/artist/artist.service';
import { ArtistDto } from 'src/app/models/artistDto';



@Component({
  selector: 'app-authorised-top-nav',
  templateUrl: './authorised-top-nav.component.html',
  styleUrls: ['./authorised-top-nav.component.css']
})
export class AuthorisedTopNavComponent implements OnInit {
artist : ArtistDto;
public spinner : boolean;
  public currentUploadFile : any;
 public currentTime : number;
 public editPhoto :boolean;
 currentFileUpload:File;
 selectedFiles : FileList;
 isShow = false;
 
 
 progress: { percentage: number } = { percentage: 0 }
  constructor(private router :Router , private artistService:ArtistService  ) {
    this.checkUser();
   }

  ngOnInit(): void {
  }
  checkUser(){
    if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null){
      this.router.navigate(['/login']);
      return;
    }
    this.artist = JSON.parse(localStorage.getItem('currentUser'));
  }

  profile(id: number){
    this.router.navigate(['/profile',id]);
  }

}

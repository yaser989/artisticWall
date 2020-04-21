import { Component, OnInit } from '@angular/core';
import {Artist} from 'src/app/models/artist';
import { Router } from '@angular/router';
import {ArtistService} from 'src/app/services/artist/artist.service';
import { HttpEventType, HttpResponse } from '@angular/common/http';


@Component({
  selector: 'app-authorised-top-nav',
  templateUrl: './authorised-top-nav.component.html',
  styleUrls: ['./authorised-top-nav.component.css']
})
export class AuthorisedTopNavComponent implements OnInit {
artist : Artist;
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

  onselected(event) {
    const file = event.target.files.item(0)
    if (file.type.match('image.*')) {
      this.selectedFiles = event.target.files;
    } else {
      alert('invalid format!');
    }
  }

  uploadPhotoArtist(id:number) {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0)
    this.artistService.uploadProductPhoto(this.currentFileUpload, id)
    .subscribe(event => {
      if(event.type === HttpEventType.UploadProgress){
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
      } else if (event instanceof HttpResponse) {
        alert('File loaded successfully');
        console.log('check if ' + event.url);
        window.location.reload();
      }
    }, err => {
        alert('Image failled to load');
    });
    this.selectedFiles = undefined;
  }

  toggleDisplay() {
    this.isShow = !this.isShow;
  }

}

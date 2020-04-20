import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Artist} from 'src/app/models/artist';
import { EventService } from 'src/app/services/event/event.service';
import { Event } from 'src/app/models/event';
import { EventDto } from 'src/app/models/eventDto';
import { ArtistDto } from 'src/app/models/artistDto';
import { HttpEventType, HttpResponse } from '@angular/common/http';


@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  progress: { percentage: number } = { percentage: 0 }
  artist :Artist ; 
 evente : EventDto;

 public spinner : boolean;
  public currentUploadFile : any;
 public currentTime : number;
 public editPhoto :boolean;
 currentFileUpload:File;
 selectedFiles : FileList;
  constructor(private router :Router, private eventService:EventService  ) {
    this.checkUser();
    
   }

  ngOnInit(): void {
    this.findAllEvent();
    
  }


/**filter(keyWord: string){
  if(keyWord === undefined || keyWord.length === 0){
    this.findAllEvent();
    return;
  }
  this.event = this.event.filter(event => 
    event.categoriesDto.toLocaleLowerCase().includes(keyWord) || event.typeEventDto.toLocaleLowerCase().includes(keyWord));
}*/



  checkUser(){
    if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null){
      this.router.navigate(['/login']);
      return;
    }
    this.artist = JSON.parse(localStorage.getItem('currentUser'));
  }

  findAllEvent(){
    this.eventService.findAllArtistEvent(this.artist.id)
    .pipe()
    .subscribe(data => {
      this.evente = data;
    }, error => {
      console.log(error);
    });
  }

  shareEvent(id : number, shared : boolean){
  this.eventService.shareEvent(id,shared)
  .pipe()
  .subscribe(data => {
    this.findAllEvent();
  });
  }

  // onEditPhoto(evente) {
  //   this.evente = evente;
  //   this.editPhoto = true;
  // }

  onselectedFile(event) {
    // this.selectedFiles = event.target.files.item(0);
    const file = event.target.files.item(0)
    if (file.type.match('image.*')) {
      this.selectedFiles = event.target.files;
    } else {
      alert('invalid format!');
    }
  }

  uploadPhoto(id:number) {
    this.progress.percentage = 0;
    this.currentFileUpload = this.selectedFiles.item(0)
    // this.spinner = true;
    this.eventService.uploadProductPhoto(this.currentFileUpload, id)
    .subscribe(event => {
      if(event.type === HttpEventType.UploadProgress){
        this.progress.percentage = Math.round(100 * event.loaded / event.total);
        // this.spinner = false;
      } else if (event instanceof HttpResponse) {
        alert('File loaded successfully');
        // this.currentTime = Date.now();
        // this.editPhoto=false;
        console.log('check if ' + event.url);
        window.location.reload();
      }
    }, err => {
        alert('Image failled to load');
    });
    this.selectedFiles = undefined;
  }
  

}

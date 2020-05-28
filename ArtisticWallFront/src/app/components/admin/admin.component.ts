import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AdminService} from 'src/app/services/admin/admin.service';
import { AdminDto } from 'src/app/models/adminDto';
import { Artist } from 'src/app/models/artist';
import { HttpEventType, HttpResponse } from '@angular/common/http';
import { EventService } from 'src/app/services/event/event.service';
import { ArtistDto } from 'src/app/models/artistDto';


@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {
  progress: { percentage: number } = { percentage: 0 }
  admin : AdminDto [];
 isAdmin : boolean = false;
  event : Event;
  artistDto : ArtistDto;
  public currentUploadFile : any;
  public currentTime : number;
  public editPhoto :boolean;
  currentFileUpload:File;
  selectedFiles : FileList;
  constructor(private router :Router ,private adminService :AdminService ,private eventService:EventService) {
    this.checkUser();
   }

  ngOnInit(): void {
    
this.AdminFindAll();
  }

  checkUser(){
    if (localStorage.getItem('currentUser') === undefined || localStorage.getItem('currentUser') === null){
      this.router.navigate(['/login']);
      return;
    }
    this.artistDto = JSON.parse(localStorage.getItem('currentUser'));
    if (this.artistDto.artistRole.match('ROLE_ADMIN')){
      this.isAdmin = true;
    }
    else {
      this.isAdmin = false;
    }
    console.log(this.artistDto);
    console.log("user is : ",this.isAdmin);
  }

  AdminFindAll(){
    this.adminService.AdminFindAll()
    .pipe()
    .subscribe(data => {
      this.admin = data;
    }, error => {
      console.log(error);
      
    
    });
}

filter(keyWord: string){
  if(keyWord === undefined || keyWord.length === 0){
    this.AdminFindAll();
    return;
  }
  this.admin = this.admin.filter(data => 
data.typeEventDto.toLocaleLowerCase().includes(keyWord) 
    
  );
}

removeEvent(id : number){
  if (id === undefined){
    alert('An error has occured while removing the event');
    return;
  }
  if(confirm("Do you relly want to remove the event")){
    this.adminService.deleteEvent(id)
    .subscribe(data =>{
     this.adminService = data
    });
  }
  window.location.reload();
}

updateEventAndArtist(idEvent : number){
  this.router.navigate(['/adminUpdate',idEvent]);
    }


    onselectedFile(event) {
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
      this.eventService.uploadProductPhoto(this.currentFileUpload, id)
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
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import {ArtistService} from 'src/app/services/artist/artist.service';
import {ArtistDto} from 'src/app/models/artistDto';
import {FormControl, Validators} from '@angular/forms';
import { HttpEventType, HttpResponse } from '@angular/common/http';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {

  artist : ArtistDto = new ArtistDto();
  id : number;
  public spinner : boolean;
  public currentUploadFile : any;
 public currentTime : number;
 public editPhoto :boolean;
 currentFileUpload:File;
 selectedFiles : FileList;
 isShow = false;
 
 
 progress: { percentage: number } = { percentage: 0 }

  constructor(private route : ActivatedRoute, private router: Router,private artistService:ArtistService) { }

  ngOnInit(): void {

    this.id = this.route.snapshot.params.id;
    this.artistService.findArtistById(this.id)
    .subscribe(data => {
      this.artist = data
      console.log(this.artist);
    });


  }

  updateArtist(){
    this.artistService.updateArtist(this.artist,this.id)
    .subscribe(data => {
      this.artist = data;
    }); 
    window.location.reload();
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

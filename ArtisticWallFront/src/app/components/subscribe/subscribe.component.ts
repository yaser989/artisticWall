import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router'; 
import {ArtistService} from 'src/app/services/artist/artist.service';
import {ArtistDto} from 'src/app/models/artistDto';
import {FormGroup, FormControl, Validators} from '@angular/forms';

@Component({
  selector: 'app-subscribe',
  templateUrl: './subscribe.component.html',
  styleUrls: ['./subscribe.component.css']
})
export class SubscribeComponent implements OnInit {
artist : ArtistDto = new ArtistDto();
artistForm :FormGroup; 
  constructor( private router : Router, private artistService :ArtistService ) { }

  ngOnInit(): void {
    this.artistForm= new FormGroup({
      ArtistName : new FormControl ('',Validators.required),
      ArtistLastName : new FormControl ('',Validators.required),
      ArtistMail : new FormControl ('',Validators.required),
      ArtistPassword : new FormControl ('',Validators.required),
      ArtistDomain : new FormControl ('',Validators.required)
    });
  }


  createNewArtist(){
    this.artistService.createNewArtist(this.artist).subscribe(data => {
      this.artist=data
      console.log(this.artist);
    });
  }
}

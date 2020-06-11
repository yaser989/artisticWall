import { Component, OnInit } from '@angular/core';
import{FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { Router } from '@angular/router';
import {ArtistService} from 'src/app/services/artist/artist.service';
import { Artist } from 'src/app/models/artist';
import { ArtistDto } from 'src/app/models/artistDto';

@Component({
  selector: 'app-first-page',
  templateUrl: './first-page.component.html',
  styleUrls: ['./first-page.component.css']
})
export class FirstPageComponent implements OnInit {
  errorMessage : string;
  public loginForm: FormGroup;
  artiste : Artist;
  artistDto: ArtistDto;
  artist : ArtistDto = new ArtistDto();
artistForm :FormGroup; 
  constructor(private artistService : ArtistService,private formBuilder: FormBuilder,private router :Router ) { 
    this.loginForm=new FormGroup({
      artistMail : new FormControl ('',Validators.required),
      artistPassword :new FormControl ('',Validators.required)
    });
  }

  ngOnInit(): void {
    this.artistForm= new FormGroup({
      ArtistName : new FormControl ('',Validators.required),
      ArtistLastName : new FormControl ('',Validators.required),
      ArtistMail : new FormControl ('',Validators.required),
      ArtistPassword : new FormControl ('',Validators.required),
      ArtistDomain : new FormControl ('',Validators.required)
    });
  }


  getUrl()
  {
    return "url('assets/R10962_image1.jpg')";
  }


  loginUser() {
    this.errorMessage = "";
    if (this.loginForm.invalid) {
      alert ('EMail and / or password is incorrect');
      return;
    }
    this.artistService.login(this.userName.value, this.password.value)
      .pipe()
      .subscribe(data => {
        localStorage.setItem('currentUser', JSON.stringify(data));
        console.log(data);
        
       
        this.router.navigate(['/home']);
      }, error => {
        if(error.status === 404) {
          alert('No user was found with the following Email/Password');
        }
        if(error.status === 400) {
          alert('EMail and / or password is incorrect');
        
        }
      });
  }

  get userName() {
    return this.loginForm.get('artistMail');
  }

  get password() {
    return this.loginForm.get('artistPassword');
  }
     
  createNewArtist(){
    this.artistService.createNewArtist(this.artist).subscribe(data => {
      this.artist=data
      console.log(this.artist);
      alert('Your account has been credited with successfully !')
    
    });

  }
}

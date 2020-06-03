import { Component, OnInit } from '@angular/core';
import{FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { Router } from '@angular/router';
import {ArtistService} from 'src/app/services/artist/artist.service';
import { Artist } from 'src/app/models/artist';
import { ArtistDto } from 'src/app/models/artistDto';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  errorMessage : string;
  public loginForm: FormGroup;
  artist : Artist;
  artistDto: ArtistDto;

  constructor(private artistService : ArtistService,private formBuilder: FormBuilder,private router :Router ) { 
    this.loginForm=new FormGroup({
      artistMail : new FormControl ('',Validators.required),
      artistPassword :new FormControl ('',Validators.required)
    });
  }


  ngOnInit(): void {
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
     
  getUrl()
  {
    return "url('assets/100143207-black-cracked-brick-tiles-wall-texture-dark-old-rough-brickwork-background.jpg')";
  }
  
}

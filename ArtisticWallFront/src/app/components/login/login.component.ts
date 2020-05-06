import { Component, OnInit } from '@angular/core';
import{FormGroup, FormBuilder, Validators, FormControl} from '@angular/forms';
import { Router } from '@angular/router';
import {ArtistService} from 'src/app/services/artist/artist.service';
import { Artist } from 'src/app/models/artist';
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  errorMessage : string;
  public loginForm: FormGroup;
  artist : Artist;

  constructor(private artistService : ArtistService,private formBuilder: FormBuilder,private router :Router ) { 
    this.loginForm=new FormGroup({
      mail : new FormControl ('',Validators.required),
      password :new FormControl ('',Validators.required)
    });
  }


  ngOnInit(): void {
  }

  
  loginUser() {
    this.errorMessage = "";
    if (this.loginForm.invalid) {
      this.errorMessage = "EMail and / or password is incorrect";
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
          this.errorMessage = "No user was found with the following Email/Password";
        }
        if(error.status === 400) {
          this.errorMessage = "EMail and / or password is incorrect";
        }
      });
  }

  get userName() {
    return this.loginForm.get('mail');
  }

  get password() {
    return this.loginForm.get('password');
  }
     

  
}

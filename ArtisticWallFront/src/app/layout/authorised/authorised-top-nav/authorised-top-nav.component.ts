import { Component, OnInit } from '@angular/core';
import {Artist} from 'src/app/models/artist';
import { Router } from '@angular/router';

@Component({
  selector: 'app-authorised-top-nav',
  templateUrl: './authorised-top-nav.component.html',
  styleUrls: ['./authorised-top-nav.component.css']
})
export class AuthorisedTopNavComponent implements OnInit {
artist : Artist;
  constructor(private router :Router ) {
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

}

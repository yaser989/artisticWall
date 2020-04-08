import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {Artist} from 'src/app/models/artist';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  artist :Artist ; 
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

import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-first-page',
  templateUrl: './first-page.component.html',
  styleUrls: ['./first-page.component.css']
})
export class FirstPageComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }


  getUrl()
  {
    return "url('assets/R10962_image1.jpg')";
  }

  
}

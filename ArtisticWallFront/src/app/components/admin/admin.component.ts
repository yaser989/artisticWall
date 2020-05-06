import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {AdminService} from 'src/app/services/admin/admin.service';
import { AdminDto } from 'src/app/models/adminDto';
import { Artist } from 'src/app/models/artist';

@Component({
  selector: 'app-admin',
  templateUrl: './admin.component.html',
  styleUrls: ['./admin.component.css']
})
export class AdminComponent implements OnInit {

  admin : AdminDto [];

  event : Event;
  
  constructor(private router :Router ,private adminService :AdminService ) {
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
    this.admin = JSON.parse(localStorage.getItem('currentUser'));
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

}

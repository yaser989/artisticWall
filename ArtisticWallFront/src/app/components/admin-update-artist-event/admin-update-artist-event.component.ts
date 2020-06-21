import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import {AdminService} from 'src/app/services/admin/admin.service';
import { AdminDto } from 'src/app/models/adminDto';
@Component({
  selector: 'app-admin-update-artist-event',
  templateUrl: './admin-update-artist-event.component.html',
  styleUrls: ['./admin-update-artist-event.component.css']
})
export class AdminUpdateArtistEventComponent implements OnInit {
admin : AdminDto = new AdminDto();
idEvent: number;
  constructor(private router :Router, private adminService: AdminService,private route : ActivatedRoute) { }

  ngOnInit(): void {

    this.idEvent = this.route.snapshot.params.idEvent;
    this.adminService.findAllByID(this.idEvent)
    .subscribe(data => {
      this.admin = data
      console.log(this.admin);
    });
    

  }


  update(){
    this.adminService.adminUpdateArtistEvent(this.admin,this.idEvent)
    .subscribe(data => {
      this.admin = data;
    }); 
    window.location.reload();
  }

  getUrl()
  {
    return "url('assets/R10962_image1.jpg')";
  }
}

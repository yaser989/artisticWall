import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUpdateArtistEventComponent } from './admin-update-artist-event.component';

describe('AdminUpdateArtistEventComponent', () => {
  let component: AdminUpdateArtistEventComponent;
  let fixture: ComponentFixture<AdminUpdateArtistEventComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminUpdateArtistEventComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminUpdateArtistEventComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorisedLayoutComponent } from './authorised-layout.component';
import { Component } from '@angular/core';
import { AuthorisedSideNavComponent } from '../authorised-side-nav/authorised-side-nav.component';
import { HomeComponent } from 'src/app/components/home/home.component';

describe('AuthorisedLayoutComponent', () => {
  let component: AuthorisedLayoutComponent;
  let fixture: ComponentFixture<AuthorisedLayoutComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorisedLayoutComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorisedLayoutComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

@Component({selector: 'app-authorised-top-nav', template: ''})
class AuthorisedTopNavComponent {}

beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AuthorisedLayoutComponent,
        AuthorisedSideNavComponent,
        AuthorisedTopNavComponent,
        HomeComponent
      ]
    })
  })
);

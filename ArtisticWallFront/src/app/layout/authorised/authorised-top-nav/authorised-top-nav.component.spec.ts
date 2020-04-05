import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuthorisedTopNavComponent } from './authorised-top-nav.component';

import { Component } from '@angular/core';
describe('AuthorisedTopNavComponent', () => {
  let component: AuthorisedTopNavComponent;
  let fixture: ComponentFixture<AuthorisedTopNavComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuthorisedTopNavComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuthorisedTopNavComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
@Component({selector: 'app-authorised-side-nav-toggler', template: ''})
class AuthorisedSideNavTogglerComponent {}

TestBed.configureTestingModule({
      declarations: [
        AuthorisedTopNavComponent,
        AuthorisedSideNavTogglerComponent
       ]
      });

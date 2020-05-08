import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AuditionComponent } from './audition.component';

describe('AuditionComponent', () => {
  let component: AuditionComponent;
  let fixture: ComponentFixture<AuditionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AuditionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AuditionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

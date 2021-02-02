import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewregisteredcourseComponent } from './viewregisteredcourse.component';

describe('ViewregisteredcourseComponent', () => {
  let component: ViewregisteredcourseComponent;
  let fixture: ComponentFixture<ViewregisteredcourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewregisteredcourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewregisteredcourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

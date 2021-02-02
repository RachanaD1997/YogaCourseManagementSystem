import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegistercourseComponent } from './registercourse.component';

describe('RegistercourseComponent', () => {
  let component: RegistercourseComponent;
  let fixture: ComponentFixture<RegistercourseComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ RegistercourseComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(RegistercourseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

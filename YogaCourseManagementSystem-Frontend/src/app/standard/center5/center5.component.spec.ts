import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Center5Component } from './center5.component';

describe('Center5Component', () => {
  let component: Center5Component;
  let fixture: ComponentFixture<Center5Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Center5Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Center5Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

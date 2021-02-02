import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Center6Component } from './center6.component';

describe('Center6Component', () => {
  let component: Center6Component;
  let fixture: ComponentFixture<Center6Component>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ Center6Component ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(Center6Component);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

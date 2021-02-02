import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewmanagersComponent } from './viewmanagers.component';

describe('ViewmanagersComponent', () => {
  let component: ViewmanagersComponent;
  let fixture: ComponentFixture<ViewmanagersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewmanagersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewmanagersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EventinfoComponent } from './eventinfo.component';

describe('EventinfoComponent', () => {
  let component: EventinfoComponent;
  let fixture: ComponentFixture<EventinfoComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EventinfoComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EventinfoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

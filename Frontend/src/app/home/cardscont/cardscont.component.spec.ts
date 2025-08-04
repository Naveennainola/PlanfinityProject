import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CardscontComponent } from './cardscont.component';

describe('CardscontComponent', () => {
  let component: CardscontComponent;
  let fixture: ComponentFixture<CardscontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CardscontComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CardscontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

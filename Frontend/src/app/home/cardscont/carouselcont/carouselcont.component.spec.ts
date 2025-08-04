import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CarouselcontComponent } from './carouselcont.component';

describe('CarouselcontComponent', () => {
  let component: CarouselcontComponent;
  let fixture: ComponentFixture<CarouselcontComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CarouselcontComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(CarouselcontComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

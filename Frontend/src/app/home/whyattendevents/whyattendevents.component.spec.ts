import { ComponentFixture, TestBed } from '@angular/core/testing';

import { WhyattendeventsComponent } from './whyattendevents.component';

describe('WhyattendeventsComponent', () => {
  let component: WhyattendeventsComponent;
  let fixture: ComponentFixture<WhyattendeventsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ WhyattendeventsComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(WhyattendeventsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

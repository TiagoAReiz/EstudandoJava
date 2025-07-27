import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BeSellerComponent } from './be-seller.component';

describe('BeSellerComponent', () => {
  let component: BeSellerComponent;
  let fixture: ComponentFixture<BeSellerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [BeSellerComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(BeSellerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

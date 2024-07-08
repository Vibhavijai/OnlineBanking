import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminaccountsComponent } from './adminaccounts.component';

describe('AdminaccountsComponent', () => {
  let component: AdminaccountsComponent;
  let fixture: ComponentFixture<AdminaccountsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AdminaccountsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminaccountsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

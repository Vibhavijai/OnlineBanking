import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LoanadminComponent } from './loanadmin.component';

describe('LoanadminComponent', () => {
  let component: LoanadminComponent;
  let fixture: ComponentFixture<LoanadminComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LoanadminComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LoanadminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

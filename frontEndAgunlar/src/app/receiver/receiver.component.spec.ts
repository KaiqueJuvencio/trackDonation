import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonatorComponent } from './receiver.component';

describe('DonatorComponent', () => {
  let component: DonatorComponent;
  let fixture: ComponentFixture<DonatorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonatorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonatorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

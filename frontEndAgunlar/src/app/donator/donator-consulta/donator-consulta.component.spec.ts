import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonatorConsultaComponent } from './donator-consulta.component';

describe('DonatorConsultaComponent', () => {
  let component: DonatorConsultaComponent;
  let fixture: ComponentFixture<DonatorConsultaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonatorConsultaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonatorConsultaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

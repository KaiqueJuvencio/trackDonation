import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DonatorCadastroComponent } from './donator-cadastro.component';

describe('DonatorCadastroComponent', () => {
  let component: DonatorCadastroComponent;
  let fixture: ComponentFixture<DonatorCadastroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DonatorCadastroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DonatorCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

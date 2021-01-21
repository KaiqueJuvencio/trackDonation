import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceiverConsultaComponent } from './receiver-consulta.component';

describe('DonatorConsultaComponent', () => {
  let component: ReceiverConsultaComponent;
  let fixture: ComponentFixture<ReceiverConsultaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReceiverConsultaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceiverConsultaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ReceiverCadastroComponent } from './receiver-cadastro.component';

describe('ReceiverCadastroComponent', () => {
  let component: ReceiverCadastroComponent;
  let fixture: ComponentFixture<ReceiverCadastroComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ReceiverCadastroComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ReceiverCadastroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

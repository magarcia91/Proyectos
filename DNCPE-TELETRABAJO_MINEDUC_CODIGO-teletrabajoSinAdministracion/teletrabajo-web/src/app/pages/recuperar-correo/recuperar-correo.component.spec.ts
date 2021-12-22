import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RecuperarCorreoComponent } from './recuperar-correo.component';

describe('RecuperarCorreoComponent', () => {
  let component: RecuperarCorreoComponent;
  let fixture: ComponentFixture<RecuperarCorreoComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RecuperarCorreoComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RecuperarCorreoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

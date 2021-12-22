import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SocioEmocionalComponent } from './socio-emocional.component';

describe('SocioEmocionalComponent', () => {
  let component: SocioEmocionalComponent;
  let fixture: ComponentFixture<SocioEmocionalComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SocioEmocionalComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SocioEmocionalComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

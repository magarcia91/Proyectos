import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ContactoEmailComponent } from './contacto-email.component';

describe('ContactoEmailComponent', () => {
  let component: ContactoEmailComponent;
  let fixture: ComponentFixture<ContactoEmailComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ContactoEmailComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ContactoEmailComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

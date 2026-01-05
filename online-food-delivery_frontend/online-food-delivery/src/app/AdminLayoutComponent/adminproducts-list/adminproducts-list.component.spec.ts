import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminproductsListComponent } from './adminproducts-list.component';

describe('AdminproductsListComponent', () => {
  let component: AdminproductsListComponent;
  let fixture: ComponentFixture<AdminproductsListComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ AdminproductsListComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(AdminproductsListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OperacionesTable } from './operaciones-table';

describe('OperacionesTable', () => {
  let component: OperacionesTable;
  let fixture: ComponentFixture<OperacionesTable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [OperacionesTable],
    }).compileComponents();

    fixture = TestBed.createComponent(OperacionesTable);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

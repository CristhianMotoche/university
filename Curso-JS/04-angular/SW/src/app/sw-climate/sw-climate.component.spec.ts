import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwClimateComponent } from './sw-climate.component';

describe('SwClimateComponent', () => {
  let component: SwClimateComponent;
  let fixture: ComponentFixture<SwClimateComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwClimateComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwClimateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

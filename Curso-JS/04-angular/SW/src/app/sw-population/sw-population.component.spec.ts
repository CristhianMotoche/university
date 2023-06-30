import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwPopulationComponent } from './sw-population.component';

describe('SwPopulationComponent', () => {
  let component: SwPopulationComponent;
  let fixture: ComponentFixture<SwPopulationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwPopulationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwPopulationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

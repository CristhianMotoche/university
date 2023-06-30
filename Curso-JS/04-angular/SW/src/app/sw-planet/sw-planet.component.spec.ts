import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwPlanetComponent } from './sw-planet.component';

describe('SwPlanetComponent', () => {
  let component: SwPlanetComponent;
  let fixture: ComponentFixture<SwPlanetComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwPlanetComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwPlanetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

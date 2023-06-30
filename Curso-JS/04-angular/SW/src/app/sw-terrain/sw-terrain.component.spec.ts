import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SwTerrainComponent } from './sw-terrain.component';

describe('SwTerrainComponent', () => {
  let component: SwTerrainComponent;
  let fixture: ComponentFixture<SwTerrainComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SwTerrainComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SwTerrainComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});

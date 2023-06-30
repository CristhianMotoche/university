import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { SwPlanetComponent } from './sw-planet/sw-planet.component';
import { SwPopulationComponent } from './sw-population/sw-population.component';
import { SwFilmsComponent } from './sw-films/sw-films.component';
import { SwClimateComponent } from './sw-climate/sw-climate.component';
import { SwTerrainComponent } from './sw-terrain/sw-terrain.component';

@NgModule({
  declarations: [
    AppComponent,
    SwPlanetComponent,
    SwPopulationComponent,
    SwFilmsComponent,
    SwClimateComponent,
    SwTerrainComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}

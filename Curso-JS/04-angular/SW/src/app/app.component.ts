import { Component } from '@angular/core';
import { Http } from '@angular/http';

import { Planet } from "app/interfaces/Planet";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  planets:Planet[] = []

  constructor(private _http: Http) {
  }

  ngOnInit(){
    this.loadPlanets()
  }

  loadPlanets() {
    this._http
      .get("http://swapi.co/api/planets/")
      .subscribe(
        (planets) => {
          let results = planets.json().results;
          results.map((planet) => planet.src = `assets/img/${ planet.name }.png`)
          results.map((planet) => planet.terrain = planet.terrain.split(','))
          results.map((planet) => planet.climate = planet.climate.split(','))
          this.planets = results
        },
        (error) => { alert(error) },
        () => {}
      )
  }
}


import { Component, OnInit, Input } from '@angular/core';

import { Planet } from "app/interfaces/Planet";

@Component({
  selector: 'app-sw-planet',
  templateUrl: './sw-planet.component.html',
  styleUrls: ['./sw-planet.component.css']
})
export class SwPlanetComponent implements OnInit {
  @Input() planet:Planet

  constructor() { }

  ngOnInit() {
  }
}


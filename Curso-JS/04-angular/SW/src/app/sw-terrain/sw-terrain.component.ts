import { Component, OnInit, Input  } from '@angular/core';

@Component({
  selector: 'app-sw-terrain',
  templateUrl: './sw-terrain.component.html',
  styleUrls: ['./sw-terrain.component.css']
})
export class SwTerrainComponent implements OnInit {
  @Input() terrains:string[]

  constructor() { }

  ngOnInit() {
  }

}

import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-sw-population',
  templateUrl: './sw-population.component.html',
  styleUrls: ['./sw-population.component.css']
})
export class SwPopulationComponent implements OnInit {
  @Input() population:number

  constructor() { }

  ngOnInit() {
  }

}

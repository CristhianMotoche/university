import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-sw-climate',
  templateUrl: './sw-climate.component.html',
  styleUrls: ['./sw-climate.component.css']
})
export class SwClimateComponent implements OnInit {
  @Input() climates:string[] 

  constructor() { }

  ngOnInit() {
  }

}

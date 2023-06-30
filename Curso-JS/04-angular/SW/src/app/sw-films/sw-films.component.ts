import { Component, OnInit, OnChanges, SimpleChange, Input } from '@angular/core';

@Component({
  selector: 'app-sw-films',
  templateUrl: './sw-films.component.html',
  styleUrls: ['./sw-films.component.css']
})
export class SwFilmsComponent implements OnInit {
  @Input() films:string[] = []
  numberOfFilms:number

  constructor() {
  }

  ngOnChanges(changes: SimpleChange) {
    this.numberOfFilms = this.films.length
  }

  ngOnInit() {
  }

}

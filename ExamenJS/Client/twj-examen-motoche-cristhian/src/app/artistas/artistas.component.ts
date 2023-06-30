import { Component, OnInit, Input } from '@angular/core';

import { Artista } from 'app/Model/Artista';

@Component({
  selector: 'app-artista',
  templateUrl: './artistas.component.html',
  styleUrls: ['./artistas.component.css']
})
export class ArtistaComponent implements OnInit {
  @Input() artista:Artista

  constructor() { }

  ngOnInit() {
  }
}

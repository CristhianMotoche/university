import { Component } from '@angular/core';

import { Http } from '@angular/http';

import { Artista } from 'app/Model/Artista';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  artista:Artista = {
    id: 0,
    nombre: '',
    estilo: '',
    pais_residencia: 'Ecuador',
    createdAt: new Date(),
    updatedAt: new Date()
  }

  artistas?:Artista[]

  constructor(private _http: Http ){ }

  createArtist(){
    this._http
      .post("http://localhost:8000/artista", this.artista)
      .subscribe(
        (response) => {
          this.artistas.push(this.artista);
        },
        (error) => { console.log(error); },
        () => {}
      )
  }

  loadArtistas() {
    this._http
      .get("http://localhost:8000/artista")
      .subscribe(
        (response) => {
          this.artistas = response.json();
        },
        (error) => { console.log(error); },
        () => {}
      )
  }

  ngOnInit() {
    this.loadArtistas()
  }
}

import { Component, OnInit } from '@angular/core';
import { Http } from '@angular/http';

@Component({
  selector: 'app-stylo',
  templateUrl: './stylo.component.html',
  styleUrls: ['./stylo.component.css']
})
export class StyloComponent implements OnInit {

  constructor(private _http: Http) {
  }

  planets = []

  loadPlanets(){
    this._http
      .get("http://swapi.co/api/planets")
      .subscribe(
        (planets) =>  {
          this.planets = planets.json().results;
          console.log(this.planets);
        } // Try
        , (res) => { console.log(res) } // Catch
        , () => { /* console.log("Finish!"); */ } // Finally
      )
  }

  userArray = [
    { nombre: "Hello",
      apellido: "World!",
      image: "https://www.adherecreative.com/hs-fs/hub/105208/file-16346453-jpeg/images/twitter-small-business-marketing.jpeg",
      conectado: true
    },
    { nombre: "Hello2",
      apellido: "World2!",
      image: "https://www.adherecreative.com/hs-fs/hub/105208/file-16346453-jpeg/images/twitter-small-business-marketing.jpeg",
      conectado: false
    },
    { nombre: "Hello3",
      apellido: "World3!",
      image: "https://www.adherecreative.com/hs-fs/hub/105208/file-16346453-jpeg/images/twitter-small-business-marketing.jpeg",
      conectado: true
    }
  ]

  value:string = "Hello!";

  ngOnInit() {
  }

  changeInput(labelName){
    console.log(labelName);
    console.log(labelName.value);
  }
}

import { Component } from '@angular/core';
import { Http, Headers, Response, RequestOptions } from '@angular/http';
import { Card } from 'app/models/Card';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  savedCard:Card = undefined
  cards:Card[] = []

  constructor(private _http: Http){ }

  ngOnInit(){
    this.loadCards()
  }

  loadCards() {
    this._http
      .get("http://yugiohprices.com/api/top_100_cards")
      .subscribe(
        (response) => {
          let cardsResponse = response.json().data;
          this.cards = cardsResponse;
          this.cards.map(c => {
            c.save = true;
            c.delete = false;
          });
        },
        (error) => { console.log(error); },
        () => {}
      )
  }

  getDataBluemix(){
    this._http
      .get("https://cristhianmotoche.mybluemix.net/cards")
      .subscribe(
        (response) => {
          let cardsResponse = response.json();
          this.cards = cardsResponse;
          this.cards.map(c => {
            c.save = false;
            c.delete = true;
          });
        },
        (error) => { console.log(error); },
        () => {}
      )
  }

  cardWasSaved(event) {
    this.savedCard = event;
  }

  cardWasDeleted(event) {
    let index = this.cards.findIndex(c => c.name === event.name);
    if (index >= 0) {
      this.cards.splice(index, 1);
    }
  }
}

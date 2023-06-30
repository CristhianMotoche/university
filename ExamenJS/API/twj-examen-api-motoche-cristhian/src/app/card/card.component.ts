import { Component
  , OnInit
  , Input
  , Output
  , EventEmitter } from '@angular/core';
import { Http } from '@angular/http';
import { Card } from 'app/models/Card';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {
  @Input() card:Card
  @Output()
  cardSavedEvent: EventEmitter<Card> = new EventEmitter<Card>();
  @Output()
  cardDeletedEvent: EventEmitter<Card> = new EventEmitter<Card>();

  constructor(
    private _http: Http
  ) { }

  ngOnInit() {
  }

  saveCard(){
    this.cardSavedEvent.emit(this.card);
    this._http
      .post('https://cristhianmotoche.mybluemix.net/card', this.card)
      .subscribe(
        (response) => {
          console.log("[RESPONSE]:", response);
        },
        (error) => {
          console.error("[ERROR]:", error);
        },
        () => {}
      )
  }

  deleteCard(){
    this.cardDeletedEvent.emit(this.card);
    this._http
      .delete('https://cristhianmotoche.mybluemix.net/card/delete?name=' + this.card.name)
      .subscribe(
        (response) => {
          console.log("[RESPONSE]:", response);
        },
        (error) => {
          console.error("[ERROR]:", error);
        },
        () => {}
      )
  }
}

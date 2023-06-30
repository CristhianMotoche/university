import { Component } from '@angular/core';

@Component({
  selector: 'raiz',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'Hello world!';
  name = '';
  lastname = 'Motoche';
  url:string = 'https://angular.io';
  url_image:string = 'https://cdn.worldvectorlogo.com/logos/angular-icon-1.svg';
  parrafo:string = "";
  color:string = "#157357";

  constructor(){
    setTimeout(function() { this.name = "Alberto"; }, 3);
    this.parrafo = "I love my mom <3";
    console.log("Hello!");
    console.log(this.greet("Cristhian"));
  }

  holaMundo(){
    console.log(`Hello world! ${this.name}`);
  }

  greet(name:string, lastname?: string): string {
    return `Hello ${name} ${lastname}`;
  }
}

interface UserInterface {
  name: string,
  lastname: string
}

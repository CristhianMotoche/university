import { Component, OnInit, Input } from '@angular/core';
import { Http } from '@angular/http';

import { User } from "app/Classes/User";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private _http: Http) { }

  newUser:User = new User();
  users?:User[]

  createUser(){
    this._http
      .post("http://localhost:8000/usuario", this.newUser)
      .subscribe(
        (response) => {
          let newUser:User = response.json();
          this.users.push(newUser);
        },
        (error) => { console.log(error); },
        () => {}
      )
  }

  loadUsers(){
    this._http
      .get("http://localhost:8000/usuario")
      .subscribe(
        (response) => {
          this.users = response.json();
        },
        (error) => { console.log("[ERROR]:", error) },
        () => {}
      )
  }

  deleteUser(id:string){
    this._http
      .delete(`http://localhost:8000/usuario/${id}`)
      .subscribe(
        (response) => {
          console.log(response);
          this.users = this.users.filter((user) => user.id !== id);
        },
        (error) => { console.log("[ERROR]:", error) },
        () => {}
      )
  }

  ngOnInit() {
  }
}

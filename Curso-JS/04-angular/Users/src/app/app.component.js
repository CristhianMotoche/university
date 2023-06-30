"use strict";
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
exports.__esModule = true;
var core_1 = require("@angular/core");
var User_1 = require("app/Classes/User");
var AppComponent = (function () {
    function AppComponent(_http) {
        this._http = _http;
        this.newUser = new User_1.User();
    }
    AppComponent.prototype.createUser = function () {
        this._http
            .post("http://localhost:8000/usuario", this.newUser)
            .subscribe(function (response) {
            console.log(response);
        }, function (error) { console.log(error); }, function () { });
    };
    AppComponent.prototype.loadUsers = function () {
        var _this = this;
        this._http
            .get("http://localhost:8000/usuario")
            .subscribe(function (response) {
            _this.users = response.json();
        }, function (error) { console.log("[ERROR]:", error); }, function () { });
    };
    AppComponent.prototype.ngOnInit = function () {
    };
    return AppComponent;
}());
AppComponent = __decorate([
    core_1.Component({
        selector: 'app-root',
        templateUrl: './app.component.html',
        styleUrls: ['./app.component.css']
    })
], AppComponent);
exports.AppComponent = AppComponent;

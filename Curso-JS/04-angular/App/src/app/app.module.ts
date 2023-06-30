import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { StyloComponent } from './stylo/stylo.component';
import { InitComponent } from './init/init.component';
import { GithubComponent } from './github/github.component';

@NgModule({
  declarations: [
    AppComponent,
    StyloComponent,
    InitComponent,
    GithubComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
//  bootstrap: [InitComponent]
//  bootstrap: [GithubComponent]
  bootstrap: [StyloComponent]
})
export class AppModule { }

import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms'; //This enables me to have the user input something.
import { HttpModule } from '@angular/http';
import { Routes } from '@angular/router'

import { AppComponent } from './app.component';
import { DungeonComponent } from './dungeon/dungeon.component';
import { LockersComponent } from './lockers/lockers.component' // Because TS doesn't know where to find DungeonComponent.

// Because single page web apps doesn't make any sense.
const appRoutes: Routes = [
  { path: 'users' } 
];

@NgModule({
  declarations: [
    AppComponent,
    DungeonComponent,
    LockersComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

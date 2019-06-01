import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'gym-lockers',
  //When you wrap the selector with [], the Angular tries to found the selector via attributes, not an element.
  //selector: '[gym-lockers]'
  //The below enables the Angular to find a selector via class.
  //selector: '.gym-lockers'
  //You can actually do something like below.
  //templateUrl: 'lockers.component.html',
/*
  //If I use backticks like this, I can just write html code, as if I am using <script>.
  template:
  `
    <h1> Who's the boss of this gym now? </h1>
  `
*/
  template: '<dungeon-master></dungeon-master><dungeon-master></dungeon-master>',
  styleUrls: ['./lockers.component.css']
})
export class LockersComponent implements OnInit {

  constructor() { }

  ngOnInit() {
    console.log("Hey! The leather club is two blocks that way! I think you got the wrong gym!");
  }

}

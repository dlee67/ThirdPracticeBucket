import { Component } from '@angular/core';

@Component({
  selector: 'dungeon-master',
  templateUrl: './dungeon.component.html'
})
export class DungeonComponent {

  boyNextDoor = "dungeon master.";
  name = "Van Darkholme";
  isItBilly = false;

  sayAniki(){
    alert("Aniki!")
  }

  changeName(event: Event){
    //If I don't cast below, then nothing works.
    this.name = (<HTMLInputElement>event.target).value;
    console.log("My name is: " + this.name);
    if(this.name == "Billy"){
      console.log("Wrestle in peace.");
    }
  }
}

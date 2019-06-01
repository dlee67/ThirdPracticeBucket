import { Component, OnInit, OnDestroy } from '@angular/core';

import 'rxjs/Rx';
import { Observer } from 'rxjs/Rx';
import { Observable } from 'rxjs/Observable';
import { Subscription } from 'rxjs/Subscription';

//Essentially, this is the View the users see when they run the application.
//The annotations are called decorators in Angular.
@Component({
  selector: 'app-root', // This is some voo doo stuff.
                        //When I look at the index.html,
                        //I'll be able to notice that there is a tag called <app-root>,
                        //like a macro from C/C++, that entire tag is being substituted with this TS file.
  templateUrl: './app.component.html', //This is the html which this TS uses.
  styleUrls: ['./app.component.css'] //and the style here.
})
export class AppComponent implements OnInit, OnDestroy{

  gachiCounterSubscription: Subscription;

  gymMaster = 'Hey, I think you got the wrong gym!';
  vanSays = "";
  quotes = ["Boy next door", "Bondage party", "hoi hoi fried rice", "Do you like what you see?"];

  constructor(){

  }

  ngOnInit(){
    //const gachiEmitter = Observable.interval(1000);
    /*
      Essentially, Obervables can be dealt with their
      state in error,
      when they complete,
      or the data they generate.
    */
    const gachiObserver = Observable.create((observer: Observer<string>) => {
      setTimeout(() => {
        console.log("2 second of gachi.");
      }, 2000);
      setTimeout(() => {
        console.log("Gachi complete");
        observer.complete();
      }, 5000);
    });
    this.gachiCounterSubscription = gachiObserver.subscribe(
      (data: string) => { console.log(data);},
      (error: string) => { console.log(error);},
      () => {
        console.log("Farewell, Aniki.");
        this.gachiCounterSubscription.unsubscribe();
      }
    );
    // RxJS also provides this API called Subject, which is incredible when it comes to having a component communicating with another.
    // Essentially, forms are clients' submission of data to the server.
    // Angular has its own form called ngForm.
  }

  ngOnDestroy(){
    console.log("Farewell, Aniki.");
  }

  getColor(){
    return "red";
  }
}

import { Component, OnInit, OnDestroy } from '@angular/core';

import 'rxjs/Rx';
import { Observer, Subject } from 'rxjs/Rx';
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
  observer = {
    next: function(value) {
      alert(value);
    },
    error: function(error){
      console.log(error);
    },
    complete: function() {
      console.log('Completed');
    }
  };

  subject = new Subject();

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

    var observableMapDemo = Observable.interval(1000);
    var observerMapDemo = {
      next: function(value) {
        console.log(value);
      }
    }
    observableMapDemo.map(function(value) {
      return "Why hello there?"; // So, whatever that is being returned here, is passed to the observer being subscribed.
    }).throttleTime(2000) // throttleTime() does not behave like sleep. The operation is still happening, but it's not effecting anything.
    .subscribe(observerMapDemo);

    //Subject remedies such problem by having the next, error, and complete be invokable like methods,
    //var subject = new Subject();
    this.subject.subscribe({
      next: function(value){
        alert(value);
      },
      error: function(error){
        console.log(error);
      },
      complete: function(){
        console.log('Complete');
      }
    });
    //subject.next("Subject's next function was called."); // and have it be invoked when the programmer wants to.
  }

  ngOnDestroy(){
    console.log("Farewell, Aniki.");
  }

  getColor(){
    return "red";
  }

  //The differences between those two are clear.
  gachiClick(){
    Observable.create(function(obs) {
      obs.next("Are you embarassing me, huh?");
      obs.complete("Gachi complete.");
    }).subscribe(this.observer);
  }
  gachiSubject(){
    this.subject.next("Aniki subject.");
  }
}

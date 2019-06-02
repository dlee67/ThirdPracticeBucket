import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {

  techSitesClicked = false;
  academicSitesClicked = false;
  foodSitesClicked = false;

  showTechSites(){
    console.log("showTechSites was invoked.");
    this.techSitesClicked = true;
    this.academicSitesClicked = false;
    this.foodSitesClicked = false;
  }

  showAcademicSites(){
    console.log("showAcademicSites was invoked.");
    this.techSitesClicked = false;
    this.academicSitesClicked = true;
    this.foodSitesClicked = false;
  }

  showFoodSites(){
    console.log("showFoodSites was invoked.");
    this.techSitesClicked = false;
    this.academicSitesClicked = false;
    this.foodSitesClicked = true;
  }

}

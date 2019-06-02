import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';

describe('AppComponent', () => {
  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));

  it('Checks the boolean values of the AppComponent.', () => {

    const mainComponent = new AppComponent();

    mainComponent.showTechSites();
    expect(mainComponent.techSitesClicked).toBeTruthy();
    expect(mainComponent.academicSitesClicked).toBeFalsy();
    expect(mainComponent.foodSitesClicked).toBeFalsy();

    mainComponent.showAcademicSites();
    expect(mainComponent.techSitesClicked).toBeFalsy();
    expect(mainComponent.academicSitesClicked).toBeTruthy();
    expect(mainComponent.foodSitesClicked).toBeFalsy();

    mainComponent.showFoodSites();
    expect(mainComponent.techSitesClicked).toBeFalsy();
    expect(mainComponent.academicSitesClicked).toBeFalsy();
    expect(mainComponent.foodSitesClicked).toBeTruthy();
  });
});

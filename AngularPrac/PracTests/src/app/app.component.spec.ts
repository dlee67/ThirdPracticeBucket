import { TestBed, async } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { TestComponent } from './test-component/test-component.component';

describe('AppComponent', () => {

  beforeEach(async(() => {
    //Configures and initialzes environment for testing.
    //You know how, in Android, you have to called specific APIs
    //to initialize objects and stuff?
    //Similar concepts going on here.
    TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
    }).compileComponents();
  }));

  /*
  it(`should have as title 'PracTests'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.debugElement.componentInstance;
    expect(app.title).toEqual('PracTests');
  });
  */

  it(`What is this suppose to do.`, () => {
    const comp = new TestComponent();
    expect(comp.whyIsTSCalledTS()).toMatch("Cause it has types.");
  });
});

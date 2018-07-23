import { async, ComponentFixture, TestBed} from '@angular/core/testing';

import { By }           from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { HierarchyService } from '../service/hierarchy.service';
import { getTestHierarchies, TestHierarchyService } from '../service/test/test-hierarchy.service';
import { HierarchyComponent } from './hierarchy.component';

const HIERARCHIES = getTestHierarchies();
let fixture: ComponentFixture<HierarchyComponent>;
let page: Page;

describe('HierarchyComponent', () => {
  let component: HierarchyComponent;
  //let fixture: ComponentFixture<HierarchyComponent>;

  beforeEach(async(() => {

    TestBed.configureTestingModule({
      declarations: [ HierarchyComponent],
      providers:    [ {provide: HierarchyService, useClass: TestHierarchyService } ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HierarchyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
     return fixture.whenStable().then(() => {
      // got the heroes and updated component
      // change detection updates the view
      fixture.detectChanges();
      page = new Page();
    });   
    
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should display hierarchies', () => {
    expect(page.hierarchyRows.length).toBeGreaterThan(0);
  });  

  it('CEO should be displayed', () => {
    const expectedHierarchy = HIERARCHIES[0];
    const actualHierarchy = page.hierarchyRows[0].textContent;
    expect(actualHierarchy).toContain(expectedHierarchy.employeeName);
  });

  it('level 2 employee should be displayed', () => {
    const expectedHierarchy = HIERARCHIES[1];
    const actualHierarchy = page.hierarchyRows[1].textContent;
    expect(actualHierarchy).toContain(expectedHierarchy.employeeName);
  });
 
  it('level 3 employee should be displayed', () => {
    const expectedHierarchy = HIERARCHIES[2];
    const actualHierarchy = page.hierarchyRows[2].textContent;
    expect(actualHierarchy).toContain(expectedHierarchy.employeeName);
  }); 


});

class Page {
  /** Hero line elements */
  hierarchyRows: HTMLElement[];

  constructor() {
    const hierarchyRowNodes = fixture.nativeElement.querySelectorAll('tr');
    this.hierarchyRows = Array.from(hierarchyRowNodes);
  };
}

import { TestBed, inject, async } from '@angular/core/testing';
import { HttpClient, HttpHeaders , HttpResponse, HttpErrorResponse } from '@angular/common/http';

import { Hierarchy } from '../model/hierarchy';

import { HierarchyService } from './hierarchy.service';
import { asyncData, asyncError } from '../../testing/async-observable-helpers';

let httpClientSpy: jasmine.SpyObj<HttpClient>;

describe('HierarchyService', () => {
  const spy = jasmine.createSpyObj('HttpClient', ['get']);

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [HierarchyService,{ provide: HttpClient, useValue: spy }]
    });

     httpClientSpy = TestBed.get(HttpClient);
  });

  it('should be created', inject([HierarchyService], (hierarchyService: HierarchyService) => {
    expect(hierarchyService).toBeTruthy();
  }));

  it('should fetch hierarchies (HttpClient called once) ', inject([HierarchyService], (hierarchyService: HierarchyService) => {
	const expectedHierarchy: Hierarchy[] = [
	{ employeeName: 'Jamie' , level: 1 },
	{ employeeName: 'Alan' , level: 2 },  
	{ employeeName: 'Matin' , level: 3 },
	{ employeeName: 'Alex' , level: 3 },
	{ employeeName: 'Steve' , level: 2 },
	{ employeeName: 'David' , level: 3 }     
	];
	httpClientSpy.get.and.returnValue(asyncData(expectedHierarchy));
	hierarchyService.getHierarchies().subscribe(
	hierarchies => expect(hierarchies).toEqual(expectedHierarchy, 'expected hierarchies'),
	fail
	);	
	expect(httpClientSpy.get.calls.count()).toBe(1, 'one call');
  }));

});

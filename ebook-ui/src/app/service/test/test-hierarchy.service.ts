import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { asyncData } from '../../../testing';

import { map } from 'rxjs/operators';

// re-export for tester convenience
export { Hierarchy }          from '../../model/hierarchy';
export { HierarchyService }   from '../hierarchy.service';
export { getTestHierarchies } from './test-hierarchies';

import { Hierarchy }          from '../../model/hierarchy';
import { HierarchyService }   from '../hierarchy.service';
import { getTestHierarchies } from './test-hierarchies';

@Injectable()
/**
 * FakeHierarchyService pretends to make real http requests.
 * implements only as much of HierarchyService as is actually consumed by the app
*/
export class TestHierarchyService extends HierarchyService {

  constructor() {
    super(null);
  }

  hierarchies = getTestHierarchies();
  lastResult: Observable<any>; // result from last method call

  getHierarchies(): Observable<Hierarchy[]> {
    return this.lastResult = asyncData(this.hierarchies);
  }

}

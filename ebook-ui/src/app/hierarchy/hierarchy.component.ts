import { Component, OnInit } from '@angular/core';
import {Hierarchy} from '../model/hierarchy'
import { HierarchyService } from '../service/hierarchy.service';

@Component({
  selector: 'app-hierarchy',
  templateUrl: './hierarchy.component.html',
  styleUrls: ['./hierarchy.component.css']
})
export class HierarchyComponent implements OnInit {
  hierarchies : Hierarchy[];

  constructor(private hierarchyService: HierarchyService) { }

  ngOnInit() {
  	this.getHierarchies();
  }

  getHierarchies(): void {
    this.hierarchyService.getHierarchies()
        .subscribe(hierarchies => this.hierarchies = hierarchies);
  }  

}

import { Injectable } from '@angular/core';

import { Observable, of } from 'rxjs';

import { Hierarchy } from '../model/hierarchy';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';


@Injectable({
  providedIn: 'root',
})
export class HierarchyService {
  private hierarchyUrl = 'http://localhost:8080/api/hierarchy';

  constructor(private http: HttpClient) { }

  getHierarchies(): Observable<Hierarchy[]> {
    return this.http.get<Hierarchy[]>(this.hierarchyUrl).pipe(
      catchError(this.handleError('getHierarchies', []))
    );
  }

	/**
	 * Handle Http operation that failed.
	 * Let the app continue.
	 * @param operation - name of the operation that failed
	 * @param result - optional value to return as the observable result
	 */
	private handleError<T> (operation = 'operation', result?: T) {
	  return (error: any): Observable<T> => {

	    // TODO: send the error to remote logging infrastructure
	    console.error(error); // log to console instead

	    // Let the app keep running by returning an empty result.
	    return of(result as T);
	  };
	}

}
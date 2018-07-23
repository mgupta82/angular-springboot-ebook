import { Hierarchy } from '../../model/hierarchy';

/** return fresh array of test hierarchy */
export function getTestHierarchies(): Hierarchy[] {
	return [
	{ employeeName: 'Jamie' , level: 1 },
	{ employeeName: 'Alan' , level: 2 },  
	{ employeeName: 'Matin' , level: 3 },
	{ employeeName: 'Alex' , level: 3 },
	{ employeeName: 'Steve' , level: 2 },
	{ employeeName: 'David' , level: 3 }     
	];
}

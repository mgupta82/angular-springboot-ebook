package com.momentum.ebook.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.momentum.ebook.model.Employee;

/**
 * Employee Repository to fetch employee data
 * @author mgupta82
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	/**
	 * returns employee hierarchy using recursive query.
	 * @return List<Object[]>
	 */
	@Query(
			  value = "WITH RECURSIVE EMPLOYEECTE (id, employee_name, manager_id,EMPLEVEL,path)\r\n" + 
			  		"AS (SELECT id, employee_name, manager_id,1 EMPLEVEL, cast(employee_name as text) path\r\n" + 
			  		"FROM Employee\r\n" + 
			  		"WHERE manager_id IS NULL\r\n" + 
			  		"UNION ALL\r\n" + 
			  		"SELECT E.id, E.employee_name, E.manager_id, CTE.EMPLEVEL + 1,cast ((cte.path || '/' || E.employee_name) as text) path\r\n" + 
			  		"FROM Employee E\r\n" + 
			  		"INNER JOIN EMPLOYEECTE CTE ON E.manager_id= CTE.id\r\n" + 
			  		"WHERE E.manager_id IS NOT NULL)\r\n" + 
			  		"SELECT employee_name,EMPLEVEL\r\n" + 
			  		"FROM EMPLOYEECTE\r\n" + 
			  		"ORDER BY path", 
			  nativeQuery = true)	
	public List<Object[]> getHierarchy();
	
	public Employee findByEmployeeName(String employeeName);
	
}

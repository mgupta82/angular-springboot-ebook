package com.momentum.ebook.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.momentum.ebook.dao.EmployeeRepository;
import com.momentum.ebook.dto.Hierarchy;
import com.momentum.ebook.model.Employee;

/**
 * Employee Service to fetch employee data from repository and convert accordingly
 * @author Admin
 *
 */
@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;
	
	public Employee getEmployee(String id) {
		Optional<Employee> employee =  employeeRepository.findById(new Long(id));
		return employee.get();
	}
	
    public Employee getEmployeeByName(String employeeName) {
        return employeeRepository.findByEmployeeName(employeeName);
    }	
	
	/**
	 * return employee hierarchy
	 * @return Hierarchy[]
	 */
	public Hierarchy[] getHierarchy() {
		List<Object[]> hierarchy = employeeRepository.getHierarchy();
		Hierarchy[] hierarchies = new Hierarchy[hierarchy.size()];
		int i=0;
		for (Object[] obj:hierarchy) {
			hierarchies[i++] = new Hierarchy((String)obj[0], (Integer)obj[1]);
		}
		return hierarchies;

	}	

}

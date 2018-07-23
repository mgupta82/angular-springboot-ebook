package com.momentum.ebook.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.momentum.ebook.dto.Hierarchy;
import com.momentum.ebook.service.EmployeeService;

/**
 * Rest controller to expose required operations 
 * @author mgupta82
 *
 */
@RestController
@RequestMapping("/api")
public class EbookController {
	
    @Autowired
    private EmployeeService employeeService;
    
    @CrossOrigin
    @GetMapping("/hierarchy")
	public Hierarchy[] getHierarchy(){
		return employeeService.getHierarchy();
	}

}

package com.momentum.ebook.dao;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.momentum.ebook.dto.Hierarchy;
import com.momentum.ebook.model.Employee;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EmployeeRepositoryTest {
 
    @Autowired
    private TestEntityManager entityManager;
 
    @Autowired
    private EmployeeRepository employeeRepository;
 
    @Test
    public void whenFindByName_thenReturnEmployee() {
        // given
    	String employeeName = "Alex";
     
        // when
        Employee found = employeeRepository.findByEmployeeName(employeeName);
     
        // then
        assertThat(found.getEmployeeName(), equalTo(employeeName));
    }
    
    @Test
    public void testGetHierarchy() {
       List<Object[]> hierarchy = employeeRepository.getHierarchy();
       assertNotNull(hierarchy);
       int i =0;
		for (Object[] obj:hierarchy) {
			switch(i++) {
			case 0:
				assertEquals("Jamie", obj[0]);
				assertEquals(1, obj[1]);
				break;				
			case 1:
				assertEquals("Alan", obj[0]);
				assertEquals(2, obj[1]);
				break;				
			case 2:
				assertEquals("Alex", obj[0]);
				assertEquals(3, obj[1]);
				break;				
			case 3:
				assertEquals("Martin", obj[0]);
				assertEquals(3, obj[1]);
				break;				
			case 4:
				assertEquals("Steve", obj[0]);
				assertEquals(2, obj[1]);
				break;				
			case 5:
				assertEquals("David", obj[0]);
				assertEquals(3, obj[1]);
				break;				
				
			}

		}       
       
    }    
 
}
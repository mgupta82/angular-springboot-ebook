package com.momentum.ebook.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import com.momentum.ebook.dao.EmployeeRepository;
import com.momentum.ebook.dto.Hierarchy;
import com.momentum.ebook.model.Employee;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;


@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
	
    @TestConfiguration
    static class EmployeeServiceTestContextConfiguration {
  
        @Bean
        public EmployeeService employeeService() {
            return new EmployeeService();
        }
    }
    
    @Autowired
    private EmployeeService employeeService;
 
    @MockBean
    private EmployeeRepository employeeRepository;    
    
    @Before
    public void setUp() {
        Employee alex = new Employee(275L,"Alex",100L);
        Mockito.when(employeeRepository.findByEmployeeName(alex.getEmployeeName()))
          .thenReturn(alex);
        
        List<Object[]> hierarchy = new ArrayList<>();
        Object[] alen = new Object[2];
        alen[0] = "Alan";
        alen[1] = 1;
        hierarchy.add(alen);
        
        Mockito.when(employeeRepository.getHierarchy())
        .thenReturn(hierarchy);       
        
    }    
    
    @Test
    public void whenValidName_thenEmployeeShouldBeFound() {
        String name = "Alex";
        Employee found = employeeService.getEmployeeByName(name);
      
         assertThat(found.getEmployeeName(),equalTo(name));
     }    
    
    @Test
    public void testGetHierarchy() {
        Hierarchy[] hierarchies = employeeService.getHierarchy();
        assertNotNull(hierarchies);
        Hierarchy alan = new Hierarchy("Alan", 1);
        assertThat(hierarchies[0].getEmployeeName(),equalTo(alan.getEmployeeName()));
        assertThat(hierarchies[0].getLevel(),equalTo(alan.getLevel()));
     }      

}

package com.momentum.ebook.web;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.momentum.ebook.dto.Hierarchy;
import com.momentum.ebook.service.EmployeeService;

@RunWith(SpringRunner.class)
@WebMvcTest(EbookController.class)
public class EbookControllerTest {
	
    @Autowired
    private MockMvc mvc;
 
    @MockBean
    private EmployeeService service;	
    
    @Test
    public void givenEmployees_whenHierarchy_thenReturnJsonArray()
      throws Exception {
    	
    	Hierarchy[] hierarchies = new Hierarchy[1];
    	Hierarchy hierarchy = new Hierarchy("Alex", 1);
    	
    	hierarchies[0] = hierarchy;

        Mockito.when(service.getHierarchy())
        .thenReturn(hierarchies); 
     
        mvc.perform(get("/api/hierarchy")
          .contentType(MediaType.APPLICATION_JSON))
          .andExpect(status().isOk())
          .andExpect(jsonPath("$[0].level", is(hierarchy.getLevel())))
          .andExpect(jsonPath("$[0].employeeName", is(hierarchy.getEmployeeName())));
    }    
    

}

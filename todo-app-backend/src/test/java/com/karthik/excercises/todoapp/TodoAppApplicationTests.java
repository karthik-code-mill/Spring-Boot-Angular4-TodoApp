package com.karthik.excercises.todoapp;

import org.junit.Before;

import org.junit.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.karthik.excercises.todoapp.domain.TodoDomain;
import com.karthik.excercises.todoapp.repositories.ITodoRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TodoAppApplicationTests {

	@Autowired
	ITodoRepository todoRepository;
	
	
	@Before
	public void setupDBRecords(){
		TodoDomain domain1=new TodoDomain("Todo task1");
		TodoDomain domain2=new TodoDomain("Todo task2");
		
		todoRepository.save(domain1);
		todoRepository.save(domain2);
		
		assertNotNull(domain1.getId());
		assertNotNull(domain2.getId());
	}
	
	
	
	@Test
	public void contextLoads() {
		System.out.println("Test Completed");
	}
	
	

}

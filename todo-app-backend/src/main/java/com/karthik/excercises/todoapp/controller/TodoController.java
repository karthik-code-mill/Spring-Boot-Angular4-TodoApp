package com.karthik.excercises.todoapp.controller;


import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.karthik.excercises.todoapp.domain.TodoDomain;
import com.karthik.excercises.todoapp.repositories.ITodoRepository;

@RestController
@RequestMapping("/todoService")
@CrossOrigin("*")
public class TodoController {
	
	@Autowired
	ITodoRepository todoRepository;
	
	
	public void setupDBRecords(){
		TodoDomain domain1=new TodoDomain("Todo task demo");
		todoRepository.save(domain1);	
	}
	
	@GetMapping("/todo")
	public List<TodoDomain> getTodoList(){
		return todoRepository.findAll(new Sort(Sort.Direction.DESC, "createdDate"));
	}
	
	@PostMapping("/todo")
	public TodoDomain postTodo(@RequestBody TodoDomain todo){
		todo.setCreatedDate(new Date());
		//TODO FOR FUTURE RELASE FROM UI
		todo.setActivityDate(new Date());
		todoRepository.save(todo);
		return todo;
	}
	
	@PutMapping("/todo/{id}")
	public ResponseEntity<TodoDomain> putTodo(@PathVariable String id,@RequestBody TodoDomain todoDomain){
		TodoDomain todo=todoRepository.findOne( todoDomain.getId());
		
		if(todo==null)
			return new ResponseEntity<TodoDomain>(HttpStatus.NOT_FOUND);
		
		todo.setDesc(todoDomain.getDesc());
		todo.setActivityDate(todoDomain.getActivityDate());
		todo.setIsDone(todoDomain.getIsDone());
		todoRepository.save(todo);
		return new ResponseEntity<TodoDomain>(todo,HttpStatus.OK);
	}
	@DeleteMapping("/todo/{id}")
	public ResponseEntity<TodoDomain> deleteTodo(@PathVariable String id){
		todoRepository.delete(id);
		TodoDomain deletedTodo=new TodoDomain();
		deletedTodo.setId(id);
		return new ResponseEntity<TodoDomain>(deletedTodo,HttpStatus.OK);
	}
	
	@PostConstruct
	public void initIt() throws Exception {
		setupDBRecords();		
	}

}

package com.karthik.excercises.todoapp.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.karthik.excercises.todoapp.domain.TodoDomain;

public interface ITodoRepository extends MongoRepository<TodoDomain, String> {
	
}

import { Component, OnInit } from '@angular/core';
import { TodoService } from '../../services/todo.service';
import { BadRequestError } from '../../common/errors/bad-req-error';
import { Todo } from '../../common/todo';

@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.css']
})
export class TodoComponent implements OnInit {
  todos:any[];
  newTodo:string;

  constructor(private service:TodoService) { }

  createTodo(){
    //let newTodo={desc:this.newTodo,isDone:false,id:null,createdDate:null,activityDate:null};
    let newTodo:Todo=new Todo();
    newTodo.desc=this.newTodo;
    newTodo.isDone=false;
    newTodo.id=null;
    this.service.createTodo(newTodo)
    .subscribe(
      (todo)=>{
        this.todos.splice(0,0,todo);
        this.newTodo="";
        console.log(todo);
      }
      ,
      error=>{
       throw error;               
      }
    );
   
  }

  toggleDoneTodo(todo:Todo){
    let index=this.todos.indexOf(todo);
    todo.isDone=!todo.isDone;
    this.service.toggleIsDoneTodo(todo)
    .subscribe(
      (todo)=>{
       // this.todos.splice(index,1);
        console.log(todo);
      }
      ,
      error=>{
        todo.isDone=!todo.isDone;
       throw error;               
      }
    );
  }

  deleteTodo(todo:Todo){
    let index=this.todos.indexOf(todo);
    this.service.deleteTodo(todo.id)
    .subscribe(
      (todo)=>{
       this.todos.splice(index,1);
        console.log(todo);
      }
      ,
      error=>{       
       throw error;               
      }
    );
  }


  ngOnInit() {

    this.service.getAll()
    .subscribe(
      (todos)=>{
        this.todos=todos;
        console.log(todos);
      }
      ,
      error=>{
        if(error instanceof BadRequestError)
          alert('Invalid request error occured');
        else{
          throw error;
        }        
      }
    );
  }

}

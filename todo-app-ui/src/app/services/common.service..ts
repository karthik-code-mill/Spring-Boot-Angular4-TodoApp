import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import {Observable} from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import { BadRequestError } from '../common/errors/bad-req-error';
import { NotFoundError } from '../common/errors/not-found-error';
import { AppError } from '../common/errors/app-error';


export class CommonService {

  constructor(private url,private http:Http) { }
  
    getAll(){
        return this.http.get(this.url)
        .map(response=>response.json())
        .catch(this.handleError)
    }

    createTodo(newPost){
      return  this.http.post(this.url,newPost)
      .map(response=>response.json())
      .catch(this.handleError)
    }

    toggleIsDoneTodo(newPost){
      return  this.http.put(this.url+"/"+newPost.id,newPost)
      .map(response=>response.json())
      .catch(this.handleError)
    }

    deleteTodo(postId){
      return  this.http.delete(this.url+"/"+postId)
      .map(response=>response.json())
      .catch(this.handleError)
    }
  
    private handleError(error){
      let status=error.status
      if(status===400)
        return Observable.throw(new BadRequestError(error));
      if(status===404)
        return Observable.throw(new NotFoundError(error));
      else
        return Observable.throw(new AppError(error));
    }
  

}

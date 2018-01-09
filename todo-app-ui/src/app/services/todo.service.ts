import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import { CommonService } from './common.service.';

@Injectable()
export class TodoService extends CommonService{

  constructor(http:Http){
    super('http://localhost:8080/todoService/todo',http);
  }

}

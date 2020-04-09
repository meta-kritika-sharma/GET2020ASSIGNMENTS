import { Injectable } from '@angular/core';
import { Task } from '../../shared/task';

@Injectable({
  providedIn: 'root'
})
export class TaskService {

  private tasks: Array<Task>;

  constructor() {
    this.tasks = new Array<Task>();
  }

  getTasks(): Array<Task>{
    return this.tasks;
  }

  getTaskById(id: Number): Task{
    return this.tasks.filter(task => task.id === id)[0];
  }

  addTask(task: Task): boolean{
    if(task){
      task.creationDate = new Date();
      task.id = this.tasks.length;
      this.tasks.push(task);
      return true;
    }
    return false;
  }

  editTask(task: Task): boolean{
    for(let i=0;i<this.tasks.length;i++){
      if(this.tasks[i].id === task.id){
        this.tasks[i] = task;
        return true;
      }
    }
    return false;
  }

  deleteTask(id: Number): boolean{
    for(let i=0;i<this.tasks.length;i++){
      if(this.tasks[i].id === id){
        this.tasks.splice(i, 1);
        return true;
      }
    }
    return false;
  }
}

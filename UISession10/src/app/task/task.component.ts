import { Component, OnInit, Input, Output } from '@angular/core';
import { Task } from '../shared/task';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { EditTaskComponent } from '../edit-task/edit-task.component';
import { TaskService } from '../services/task/task.service';
import { EventEmitter } from 'protractor';

@Component({
  selector: 'app-task',
  templateUrl: './task.component.html',
  styleUrls: ['./task.component.scss']
})
export class TaskComponent implements OnInit {

  @Input()
  task: Task;

  @Input()
  status: string;

  @Input()
  tasks: Array<Task>;

  constructor(private modalService: NgbModal,
    public taskService: TaskService) { }

  ngOnInit(): void {
  }

  getBackground(): string{
    let style: string = "background-color: ";

    if(this.task.priority === "Low"){
      return style+"#b0ecec";
    } else if(this.task.priority === "Medium"){
      return style+"#a6ceff";
    } else if(this.task.priority === "High"){
      return style+"#ffc3c3";
    } else {
      return style+"#000";
    }
  }

  openEditTask(task: Task) {
    const modalRef = this.modalService.open(EditTaskComponent);
    modalRef.componentInstance.task = task;
    modalRef.result.then(response => {
      if(response){
        this.task = this.taskService.getTaskById(this.task.id);
      }
    }).catch(() => {});
  }

  
  deleteTask(id: Number){
    this.taskService.deleteTask(id);
    this.tasks.forEach((task, i) => {
      if(task.id === id){
        this.tasks.splice(i,1);
        return false;
      }
    });
  }
}

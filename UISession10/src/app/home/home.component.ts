import { Component, OnInit } from '@angular/core';
import { NgbModal } from '@ng-bootstrap/ng-bootstrap';
import { AddTaskComponent } from '../add-task/add-task.component';
import { Task } from '../shared/task';
import { TaskService } from '../services/task/task.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  statusArr: Array<string>;
  tasks: Array<Task>;
  seperatedTasks: Array<Array<Task>>;

  constructor(private modalService: NgbModal,
    private taskService: TaskService) {
    this.statusArr = ["New", "In Progress", "Completed"];
    this.seperatedTasks = new Array<Array<Task>>(3);
  }

  ngOnInit(): void {
    this.tasks = this.taskService.getTasks();
    this.statusArr.forEach((status, i) => {
      this.seperatedTasks[i] = this.tasks.filter(task => task.status === status);
    });
  }

  getTasksWithStatus(status: string): Array<Task>{
    return this.tasks.filter(task => task.status === status);
  }

  openAddTask() {
    const modalRef = this.modalService.open(AddTaskComponent);
    modalRef.result.then(response => {
      if(response){
        this.tasks = this.taskService.getTasks();
        const task = this.tasks[this.tasks.length-1];
        this.seperatedTasks[this.statusArr.indexOf(task.status)].push(task);
      }
    }).catch(() => {});
  }

}

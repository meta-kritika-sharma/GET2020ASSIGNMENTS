import { Component, OnInit } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Task } from '../shared/task';
import { TaskService } from '../services/task/task.service';

@Component({
  selector: 'app-add-task',
  templateUrl: './add-task.component.html',
  styleUrls: ['./add-task.component.scss']
})
export class AddTaskComponent implements OnInit {

  task: Task;

  constructor(public activeModal: NgbActiveModal,
    public taskService: TaskService) {
    this.task = new Task();
    this.task.status = "New";
    this.task.priority = "Low";
  }

  ngOnInit(): void {
  }

  submit(){
    this.activeModal.close(this.taskService.addTask(this.task));
  }

  setDate(event){
    this.task.completionDate = new Date(event);
  }
}

import { Component, OnInit, Input } from '@angular/core';
import { NgbActiveModal } from '@ng-bootstrap/ng-bootstrap';
import { Task } from '../shared/task';
import { TaskService } from '../services/task/task.service';

@Component({
  selector: 'app-edit-task',
  templateUrl: './edit-task.component.html',
  styleUrls: ['./edit-task.component.scss']
})
export class EditTaskComponent implements OnInit {

  @Input()
  task: Task;

  constructor(public activeModal: NgbActiveModal,
    public taskService: TaskService) {}

  ngOnInit(): void {
  }

  submit(){
    this.activeModal.close(this.taskService.editTask(this.task));
  }

  setDate(event){
    this.task.completionDate = new Date(event);
  }
}

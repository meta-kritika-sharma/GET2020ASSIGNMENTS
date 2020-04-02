import { Component, OnInit, Input, SimpleChange } from '@angular/core';
import { TaskService } from '../services/task/task.service';
import { Task } from '../shared/task';
import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-tasks',
  templateUrl: './tasks.component.html',
  styleUrls: ['./tasks.component.scss']
})
export class TasksComponent implements OnInit {

  @Input()
  status: string;

  @Input()
  statusArr: Array<string>;

  @Input()
  tasks: Array<Task>;

  constructor(public taskService: TaskService) { }

  ngOnInit(): void{ }

  onDrop(event: CdkDragDrop<string[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex);
    }
    let newStatus = event.container.id;
    if(newStatus === "InProgress"){
      newStatus = "In Progress";
    }
    
  }

  getOtherStatus(){
    return this.statusArr.filter(status => status != this.status).map(status => status.split(" ").join(''));
  }
}

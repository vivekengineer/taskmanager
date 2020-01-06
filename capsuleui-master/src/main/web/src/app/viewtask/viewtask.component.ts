import { Component, OnInit } from '@angular/core';
import {TaskApiService} from '../service/task-api.service';
import {Router} from '@angular/router';
import {Task} from '../dto/task';
@Component({
  selector: 'app-viewtask',
  templateUrl: './viewtask.component.html',
  styleUrls: ['./viewtask.component.css']
})
export class ViewtaskComponent implements OnInit {
taskList: any =[];
searchText:string='';
display='none';
visible=false;
taskDTO: Task = new Task();
updateTaskDTO: Task = new Task() ;
deleteTaskDTO: Task = new Task() ;
  constructor(private restApi:TaskApiService, private router:Router
  ) { }
 
  ngOnInit() {
    this.getTask();
  }

  getTask(){
    return this.restApi.getAllTask().subscribe((data:{}) =>
   { this.taskList=data;}
    )
  }

  updateTask(task:Task){
    task.taskid=this.updateTaskDTO.taskid;
    return this.restApi.taskUpdate(task).subscribe((data:{}) =>
   {  this.getTask()}
    )
  }

  deleteTask(task:Task){
    return this.restApi.taskDelete(task).subscribe(data=>{
      this.getTask();
    })
    
  }

  openModalDialog(selectedItem: any){
    this.display='block';
    this.updateTaskDTO = selectedItem;
  }

  closeModalDialog(){
    this.display='none';
  }
}

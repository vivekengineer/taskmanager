import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router'
import {TaskApiService} from '../service/task-api.service'
import {HttpClient} from '@angular/common/http'
import {Task} from '../dto/task'
@Component({
  selector: 'app-addtask',
  templateUrl: './addtask.component.html',
  styleUrls: ['./addtask.component.css']
})
export class AddtaskComponent implements OnInit {

   taskDto:Task = new Task();
  constructor(private http:HttpClient,private router:Router, private taskapiSrvc:TaskApiService) { }

  error:any={isError:false,errorMessage:''};
   
  compareTwoDates(){ 
    this.error={isError:false,errorMessage:''};
     if(new Date(this.taskDto.toDate)<new Date(this.taskDto.startDate)){
        this.error={isError:true,errorMessage:'End Date can not before start date'};
     } 
  } 

  ngOnInit() {
  }

  public addTaskDTO(){
    this.taskapiSrvc.addTask(this.taskDto).subscribe(data=>{        
      this.router.navigate(['/viewtask']); 
    });
    
  }
}

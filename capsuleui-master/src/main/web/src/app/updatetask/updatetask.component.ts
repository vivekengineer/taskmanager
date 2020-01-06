import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Router} from '@angular/router';
import {TaskApiService} from '../service/task-api.service';

@Component({
  selector: 'app-updatetask',
  templateUrl: './updatetask.component.html',
  styleUrls: ['./updatetask.component.css']
})
export class UpdatetaskComponent implements OnInit {
display='none';
  constructor(private http:HttpClient, private router:Router, private taskApiService:TaskApiService) { }

  ngOnInit() {
  }

  openModalDialog(){
    this.display='block';

  }

  closeModalDialog(){
    this.display='none';
  }
  
  

}
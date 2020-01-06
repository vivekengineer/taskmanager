import { Injectable } from '@angular/core';
import { HttpHeaders, HttpClient } from '@angular/common/http'
import { Observable, throwError } from 'rxjs'
import { retry, catchError } from 'rxjs/operators'
import { Task } from '../dto/task';

@Injectable({
  providedIn: 'root'
})
export class TaskApiService {

  apiURI = "http://localhost:8081"
  constructor(private http: HttpClient) {
  }

  httpOptions = {
    headers: new HttpHeaders({
      'Conetent-Type': 'text/plain',
    })
  }

  public addTask(task: Task){
    return this.http.post<Task>(this.apiURI+"/addTask",task,{responseType: 'text' as 'json'});
  }

  public getAllTask() {
    return this.http.get<Task>(this.apiURI + "/getTask")
      .pipe(retry(1), catchError(this.handleError))
  }

  public taskUpdate(task: Task){
    return this.http.put<Task>(this.apiURI + "/updateTask", task,{responseType: 'text' as 'json'})
      .pipe(retry(1), catchError(this.handleError))
  }

  public taskDelete(task: Task){
    return this.http.put<Task>(this.apiURI + "/deleteTask", task,{responseType: 'text' as 'json'})
      .pipe(retry(1), catchError(this.handleError))
  }

  handleError(error) {
    let errorMessage = "";
    if (error.error instanceof ErrorEvent) {
      errorMessage = error.error.message;
    }
    else {
      errorMessage = 'Error Code: ${error.status}\n Error Message: ${error.message}';
    }

    window.alert(errorMessage);
    return throwError(errorMessage);
  }
}

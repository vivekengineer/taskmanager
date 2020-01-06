import { Pipe, PipeTransform,Injectable } from '@angular/core'
import {DatePipe} from '@angular/common'
import {Task} from '../dto/task'
@Pipe({
    name: 'filter'
})
@Injectable()
export class FilterPipe implements PipeTransform {
    transform(taskList: Task[], field: string, value: string): Task[] {
        if (!taskList) {
            return [];
        }

        if(!field || !value){
            return taskList;
        }

        if(value===""){
            return taskList;
        }else{
            if(field==="taskname"){
                return taskList.filter(filteredTask=>
                    filteredTask.taskname.includes(value));
            }
            else if(field==="parentname"){
                return taskList.filter(filteredTask=>
                    filteredTask.parentname.includes(value));
            }
            else if(field==="priorityFrom"){
                return taskList.filter(filteredTask=>
                    filteredTask.priority >= parseInt(value));
            }
            else if(field==="priorityTo"){
                return taskList.filter(filteredTask=>
                    filteredTask.priority <= parseInt(value));
            }else if(field=="startDate"){
               /* return taskList.filter(filteredTask=>{
                    var datePipe =new DatePipe("en-US");
                    let str = datePipe.transform(filteredTask.startDate,"dd-MM-yyyy");
                    if(str.includes(value)){
                        return filteredTask;
                    }
                    else{
                        return null;
                    }
                });*/
                return taskList.filter(filteredTask =>
                filteredTask.startDate <= value);
            }
            else if(field=="toDate"){
                return taskList.filter(filteredTask =>
                    filteredTask.toDate >= value);
            }
            
        }

    }
}

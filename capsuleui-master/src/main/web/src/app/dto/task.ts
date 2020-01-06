export class Task {
taskid:number;
taskname: string;
parentname: string;
priority: number;
startDate: string;
toDate: string;
status: string;

setTaskname(taskname:string){
    this.taskname = taskname;
}

}

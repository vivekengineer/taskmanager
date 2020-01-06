import { NgModule } from '@angular/core';
import {Router, RouterModule} from '@angular/router';

import {AddtaskComponent} from './addtask/addtask.component';
import {ViewtaskComponent} from './viewtask/viewtask.component';

const routes =[
    {
        path: 'addtask',
        component: AddtaskComponent
    },
    {
        path: 'viewtask',
        component: ViewtaskComponent
    }
];
@NgModule(
    {
        imports: [RouterModule.forRoot(routes)],
        exports: [RouterModule]
    }
)

export class ApproutingModule{};
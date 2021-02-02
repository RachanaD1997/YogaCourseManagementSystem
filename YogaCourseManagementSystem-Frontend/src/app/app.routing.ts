import { Routes, RouterModule } from '@angular/router';



//import { AuthGuard } from './_helpers';

const routes: Routes = [
   // { path: '', component: HomeComponent, canActivate: [AuthGuard] },
   // { path: 'userlogin', component: RegisterUserComponent },
   

    // otherwise redirect to home
    { path: '**', redirectTo: '' }
];

export const appRoutingModule = RouterModule.forRoot(routes);
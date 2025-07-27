import { HomeComponent } from './components/home/home.component';
import { Routes } from '@angular/router';
import { UserFormComponent } from './components/user-form/user-form.component';
import { LoginComponent } from './components/login/login.component';
import { BeSellerComponent } from './components/be-seller/be-seller.component';

export const routes: Routes = [
    {
        path: '',
        component: HomeComponent,
    },
     {
        path: 'sign',
        component: UserFormComponent,
    },
    {
        path: 'login',
        component: LoginComponent,
    },
    {
        path: 'beSeller',
        component: BeSellerComponent,
    },
];

import { Component } from '@angular/core';
import { UserServiceService } from '../../services/user-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterLink, Router } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-login',
  imports: [FormsModule, HttpClientModule,RouterLink, NgIf ],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
constructor(private userService: UserServiceService, private router: Router) {}
  credentials = {
    email: '',
    password: ''
  };

   loginError: string | null = null;

  login(credentials: any) {

    this.loginError = null; 
    
    this.userService.login(credentials).subscribe({
      next: (response) => {
        console.log('Login successful');
        localStorage.setItem('authToken', response.token);
        this.router.navigate(['/']);
      },
      error: (error) => {
        console.error('Login failed:', error);

        this.loginError = 'Email ou senha inválidos. Tente novamente.';
      }
    });
  }
}

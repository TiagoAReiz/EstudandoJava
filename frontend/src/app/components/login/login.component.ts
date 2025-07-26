import { Component } from '@angular/core';
import { UserServiceService } from '../../services/user-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
@Component({
  selector: 'app-login',
  imports: [FormsModule, HttpClientModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
constructor(private userService: UserServiceService) {}
  credentials = {
    email: '',
    password: ''
  };

  login(credentials: any) {
    this.userService.login(credentials).subscribe({
      next: (response) => {
        console.log('Login successful:', response);
        // Handle successful login, e.g., redirect to home page
      },
      error: (error) => {
        console.error('Login failed:', error);
        // Handle login error, e.g., show error message
      }
    });
  }
}

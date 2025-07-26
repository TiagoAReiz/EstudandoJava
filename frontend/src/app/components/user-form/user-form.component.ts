import { UserServiceService } from './../../services/user-service.service';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
@Component({
  selector: 'app-user-form',
  imports: [FormsModule, HttpClientModule],
  templateUrl: './user-form.component.html',
  styleUrl: './user-form.component.css'
})
export class UserFormComponent {
  constructor(private userService: UserServiceService, ) {}
  user = {
    email: '',
    password: ''
  };

  cadastrar() {
    this.userService.cadastrar(this.user).subscribe({
      next: (response) => {
        console.log('User registered:', response);
        // Handle successful registration, e.g., redirect to login page
      },
      error: (error) => {
        console.error('Registration failed:', error);
        // Handle registration error, e.g., show error message
      }
    });
  }


}

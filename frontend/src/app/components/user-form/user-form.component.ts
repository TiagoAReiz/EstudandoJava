import { UserServiceService } from './../../services/user-service.service';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterLink } from '@angular/router';
import { NgIf } from '@angular/common';
@Component({
  selector: 'app-user-form',
  imports: [FormsModule, HttpClientModule, RouterLink, NgIf],
  templateUrl: './user-form.component.html',
  styleUrl: './user-form.component.css'
})
export class UserFormComponent {
  constructor(private userService: UserServiceService, ) {}
  user = {
    email: '',
    password: ''
  };
  createError: string | null = null;
  cadastrar() {
    this.createError = null;
    this.userService.cadastrar(this.user).subscribe({
      next: (response) => {
        console.log('User registered:', response);
        this.createError = null;
        // Handle successful registration, e.g., redirect to login page
      },
      error: (error) => {
        console.error('Registration failed:', error);
        this.createError = 'Erro ao cadastrar usuário. Tente novamente.';
      }
    });
  }


}

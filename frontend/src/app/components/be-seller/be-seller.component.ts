import { Component } from '@angular/core';
import { UserServiceService } from '../../services/user-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-be-seller',
  imports: [FormsModule, HttpClientModule, RouterLink],
  templateUrl: './be-seller.component.html',
  styleUrl: './be-seller.component.css'
})
export class BeSellerComponent {
  constructor(private userService: UserServiceService) { }
  cnpj: string = '';
  beSeller(cnpj: string) {
    this.userService.beSeller(this.cnpj).subscribe({
      next: (response) => {
        console.log('Successfully became a seller:', response);
      },
      error: (error) => {
        console.error('Error becoming a seller:', error);
      }
    });
  }
}

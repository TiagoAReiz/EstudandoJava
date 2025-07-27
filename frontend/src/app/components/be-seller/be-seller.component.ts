import { Component } from '@angular/core';
import { UserServiceService } from '../../services/user-service.service';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { RouterLink, Router } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-be-seller',
  imports: [FormsModule, HttpClientModule, RouterLink, NgIf],
  templateUrl: './be-seller.component.html',
  styleUrl: './be-seller.component.css'
})
export class BeSellerComponent {
  constructor(private userService: UserServiceService, private router: Router) { }

  patchError: string | null = null;
  cnpj: string = '';
  beSeller(cnpj: string) {
    this.patchError = null;
    this.userService.beSeller(this.cnpj).subscribe({
      next: (response) => {
        console.log('Successfully became a seller:', response);
        this.router.navigate(['/']);
      },
      error: (error) => {
        console.error('Error becoming a seller:', error);
        this.patchError = 'Erro ao se tornar vendedor. Verifique o CNPJ e tente novamente.';
      }
    });
  }
}

import { ProductsService } from '../../services/products.service';
import { Component, ElementRef, AfterViewInit, OnDestroy, OnInit } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs/internal/Observable';
export interface Product {
  id: number;
  name: string;
  description: string;
  price: number;
  imageUrl: string;
}

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, HttpClientModule],
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
  

  constructor(private productsService : ProductsService) {}
  ngOnInit(): void {
    this.getProducts();
  }
    products: Product[] = [];
  getProducts ()  {
    this.productsService.getProducts().subscribe({
      next: (data) => {
        this.products = data || [];
        console.log('Products loaded:', this.products);
      },
      error: (error) => {
        console.error('Error loading products:', error);
        this.products = [];
      }
  })
}
}
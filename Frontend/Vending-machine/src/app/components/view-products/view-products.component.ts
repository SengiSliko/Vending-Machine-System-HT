import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ProductService } from '../../serices/product.sservice';

@Component({
  selector: 'app-view-products',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './view-products.component.html',
  styleUrl: './view-products.component.scss'
})
export class ViewProductsComponent implements OnInit {
  products: any[] = [];
  hoveredProductId: number | null = null;

  constructor(private productService: ProductService) {}

  ngOnInit() {
    this.loadProducts();
  }

  loadProducts() {
    this.productService.getProducts().subscribe({
      next: (data: any) => this.products = data,
      error: (error: any) => console.error('Error loading products:', error)
    });
  }

  purchaseProduct(productId: number) {
    const product = this.products.find(p => p.id === productId);
    if (product && product.stockQuantity > 0) {
      console.log('Purchasing product:', productId);
      product.stockQuantity--;
    }
  }
}
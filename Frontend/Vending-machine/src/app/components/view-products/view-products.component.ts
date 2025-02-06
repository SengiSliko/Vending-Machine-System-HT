import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { RouterLink } from '@angular/router';
import { ProductService } from '../../serices/product.sservice';
import { TransactionService } from '../../serices/transaction.service';

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
  currentCash: number = 0;

  constructor(
    private productService: ProductService,
    private transactionService: TransactionService
  ) {}

  ngOnInit() {
    this.loadProducts();
    this.transactionService.currentCash$.subscribe(
      cash => this.currentCash = cash
    );
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
      if (this.transactionService.canPurchase(product.price)) {
        if (this.transactionService.processPurchase(product.price)) {
          product.stockQuantity--;
          const change = this.transactionService.getChange();
          if (change > 0) {
            alert(`Purchase successful! Your change: R${change}`);
          } else {
            alert('Purchase successful!');
          }
        }
      } else {
        alert('Insufficient funds! Please insert more cash.');
      }
    }
  }
}

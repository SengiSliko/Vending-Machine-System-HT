import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink, Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { ProductService } from '../../serices/product.sservice';

@Component({
  selector: 'app-add-product',
  standalone: true,
  imports: [CommonModule, RouterLink, FormsModule],
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.scss'
})
export class AddProductComponent {
  newProduct = {
    name: '',
    price: 0,
    stockQuantity: 0,
    color: '',
    image: ''
  };

  constructor(
    private productService: ProductService,
    private router: Router
  ) {}

  addProduct() {
    this.productService.addProduct(this.newProduct).subscribe({
      next: () => {
        alert(`Product "${this.newProduct.name}" has been added successfully!`);
        this.router.navigate(['/view-products']); // Redirect after success
      },
      error: (error) => {
        alert('Failed to add product. Please try again.');
        console.error('Error adding product:', error);
      }
    });
  }
}
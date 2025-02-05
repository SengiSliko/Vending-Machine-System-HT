import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';


@Component({
  selector: 'app-view-products',
  imports: [CommonModule,RouterLink],
  templateUrl: './view-products.component.html',
  styleUrl: './view-products.component.scss'
})
export class ViewProductsComponent {

  products = [
    { id: 1, name: 'Coca-Cola', price: 15, stockQuantity: 10, color: 'Red' },
    { id: 2, name: 'Sprite', price: 15, stockQuantity: 8, color: 'Green' }
  ];

  ngOnInit(){

  }

  purchaseProduct(productId: number) {  // Add this method
    console.log('Purchasing product:', productId);
    // Add purchase logic here
  }

}

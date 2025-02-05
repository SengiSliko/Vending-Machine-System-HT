import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-add-product',
  imports: [CommonModule,RouterLink,FormsModule],
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

  addProduct() {
    console.log('Adding product:', this.newProduct);
    //will add API call logic here 
  }

}

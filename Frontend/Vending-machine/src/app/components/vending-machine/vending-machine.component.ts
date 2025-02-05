import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from '../../serices/product.sservice';

@Component({
  selector: 'app-vending-machine',
  imports: [],
  templateUrl: './vending-machine.component.html',
  styleUrl: './vending-machine.component.scss'
})
export class VendingMachineComponent {

  constructor(private router: Router) {}

  navigate(route: string) {
    this.router.navigate([route]);
  }
}

import { Routes } from '@angular/router';
import { VendingMachineComponent } from './components/vending-machine/vending-machine.component';
import { ViewProductsComponent } from './components/view-products/view-products.component';
import { AddProductComponent } from './components/add-product/add-product.component';
import { InsertCashComponent } from './components/insert-cash/insert-cash.component';

export const routes: Routes = [
  { path: '', component: VendingMachineComponent },
  { path: 'view-products', component: ViewProductsComponent },
  { path: 'add-product', component: AddProductComponent },
  { path: 'insert-cash', component: InsertCashComponent }
];
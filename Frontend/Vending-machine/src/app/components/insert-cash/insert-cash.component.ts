import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';
import { TransactionService } from '../../serices/transaction.service';

@Component({
  selector: 'app-insert-cash',
  standalone: true,
  imports: [CommonModule, RouterLink],
  templateUrl: './insert-cash.component.html',
  styleUrl: './insert-cash.component.scss'
})
export class InsertCashComponent {
  currentCash: number = 0;
  
  denominations = [
    { value: 5, label: 'R5' },
    { value: 10, label: 'R10' },
    { value: 20, label: 'R20' },
    { value: 50, label: 'R50' },
    { value: 100, label: 'R100' }
  ];

  constructor(private transactionService: TransactionService) {
    this.transactionService.currentCash$.subscribe(
      cash => this.currentCash = cash
    );
  }

  insertCash(value: number) {
    this.transactionService.addCash(value);
    console.log(`Added R${value}. Total: R${this.currentCash}`);
  }
}
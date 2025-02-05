import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-insert-cash',
  imports: [],
  templateUrl: './insert-cash.component.html',
  styleUrl: './insert-cash.component.scss'
})
export class InsertCashComponent {

  denominations = [
    { value: 5, label: 'R5' },
    { value: 10, label: 'R10' },
    { value: 20, label: 'R20' },
    { value: 50, label: 'R50' },
    { value: 100, label: 'R100' }
  ];

  insertCash(value: number) {
    console.log(`Inserting R${value}`);
    // Add API call logic here
  }

}

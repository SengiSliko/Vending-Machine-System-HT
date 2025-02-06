import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  private currentCashBalance = new BehaviorSubject<number>(0);
  currentCash$ = this.currentCashBalance.asObservable();

  constructor() {}

  addCash(amount: number) {
    const currentAmount = this.currentCashBalance.value;
    this.currentCashBalance.next(currentAmount + amount);
  }

  getCashBalance() {
    return this.currentCashBalance.value;
  }

  canPurchase(price: number): boolean {
    return this.currentCashBalance.value >= price;
  }

  processPurchase(price: number) {
    if (this.canPurchase(price)) {
      const newBalance = this.currentCashBalance.value - price;
      this.currentCashBalance.next(newBalance);
      return true;
    }
    return false;
  }

  getChange(): number {
    const change = this.currentCashBalance.value;
    this.currentCashBalance.next(0);  //resets balance after getting change
    return change;
  }
}
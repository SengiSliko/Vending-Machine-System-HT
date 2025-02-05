import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CashInventoryService {
  private apiUrl = 'http://localhost:8080/api/cash-inventory';

  constructor(private http: HttpClient) {}

  addCash(denomination: string, quantity: number): Observable<any> {
    return this.http.post(`${this.apiUrl}/add`, { denomination, quantity });
  }

  getCurrentInventory(): Observable<any> {
    return this.http.get(`${this.apiUrl}/current`);
  }
}
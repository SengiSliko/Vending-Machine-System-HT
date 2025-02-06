import { Component } from '@angular/core';
import { RouterLink } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-vending-machine',
  standalone: true,
  imports: [RouterLink, CommonModule],
  templateUrl: './vending-machine.component.html',
  styleUrl: './vending-machine.component.scss'
})
export class VendingMachineComponent {
  activeCard: string | null = null;
}
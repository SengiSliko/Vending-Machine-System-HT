import { Component } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { VendingMachineComponent } from './components/vending-machine/vending-machine.component';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  imports: [HttpClientModule,VendingMachineComponent,RouterOutlet],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {
  title = 'Vending-machine';
}

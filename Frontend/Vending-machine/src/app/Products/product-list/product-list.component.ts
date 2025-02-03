import { AfterViewInit, Component ,OnInit, QueryList, ViewChild, viewChild, ViewChildren} from '@angular/core';
import { Product } from '../../models/product-model';
import { ProductService } from '../product.service';
import { scroll, animate } from "motion";
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-product-list',
  imports: [CommonModule],
  providers: [ProductService],
  templateUrl: './product-list.component.html',
  styleUrl: './product-list.component.scss'
})
export class ProductListComponent implements AfterViewInit {
  @ViewChildren('slide') slides!: QueryList<HTMLElement>;
  products: Product[] = [];

  constructor(private productService: ProductService) {
  }
  
  ngOnInit(): void {
    this.productService.getProducts().subscribe((data) => {
      this.products = data;
    });    
  }

  ngAfterViewInit(): void {
    console.log("after view init")
    this.slides.forEach(el => console.log(el))
  }

}

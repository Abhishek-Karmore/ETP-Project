import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/models/product.model';
import { CartService } from 'src/app/services/cart/cart.service';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {

  categoryId!: number;
  products: Product[] = [];
  loading = true;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private productService: ProductService,
    private cartService:CartService
    
  ) {}

  ngOnInit(): void {
    this.categoryId = Number(this.route.snapshot.paramMap.get('categoryId'));
    this.fetchProducts();
  }

  fetchProducts(): void {
  this.productService.getProductsByCategory(this.categoryId)
    .subscribe({
      next: (res: any) => {

        // 🔥 IMPORTANT FIX
        this.products = res.data;

        this.loading = false;
      },
      error: (err) => {
        console.error('API Error: - products.component.ts:42', err);
        this.loading = false;
      }
    });
}

addToCart(product: any) {
  this.cartService.addToCart(product);
}


}

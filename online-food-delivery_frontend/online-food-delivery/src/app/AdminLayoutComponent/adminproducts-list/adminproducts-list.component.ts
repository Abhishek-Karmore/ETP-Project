import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-adminproducts-list',
  templateUrl: './adminproducts-list.component.html',
  styleUrls: ['./adminproducts-list.component.css']
})
export class AdminproductsListComponent implements OnInit {


  products: any[] = [];

  constructor(private productService: ProductService,
    private router: Router
  ) { }

  ngOnInit(): void {
    this.loadProducts();
  }

  loadProducts() {
    this.productService.getAllProducts().subscribe(res => {
      if (res && res.respCode === 'Success') {
        this.products = res.data;
      }
    });
  }

  //  EDIT PRODUCT
 editProduct(productId: number) {

  const selected = this.products.find(p => p.productId === productId);
  
  if (!selected) {
    alert('Product not found');
    return;
  }

  // 🔥 store product in service
  this.productService.setSelectedProduct(selected);

  // navigate WITHOUT extra API
  this.router.navigate(['/admin/edit-product']);
}


  // ❌ DELETE PRODUCT
  deleteProduct(productId: number) {
    if (confirm('Are you sure you want to delete this product?')) {
      this.productService.deleteProduct(productId).subscribe(res => {
        if (res && res.respCode === 'SUCCESS') {
          alert('Product deleted successfully');
          this.loadProducts();
        } else {
          alert('Failed to delete product');
        }
      });
    }
  }




}

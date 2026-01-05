import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/models/product.model';
import { CategoriesService } from 'src/app/services/categories/categories.service';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-edit-products',
  templateUrl: './edit-products.component.html',
  styleUrls: ['./edit-products.component.css']
})
export class EditProductsComponent implements OnInit {
  // ✅ STRONGLY TYPED + INITIALIZED
  product: Product = {
    productId: 0,
    productName: '',
    categoryId: 0,
    price: 0,
    imageUrl: ''
  };

  categories: any[] = [];

  constructor(
    private productService: ProductService,
    private categoriesService: CategoriesService,
    private router: Router
  ) { }

  ngOnInit(): void {
    const selected = this.productService.getSelectedProduct();

    if (!selected) {
      alert('No product selected');
      this.router.navigate(['/admin/products-list']);
      return;
    }

    // 1️⃣ Assign product immediately (fields show)
    this.product = { ...selected };

    // 2️⃣ Preload ONLY selected category
    this.categories = [{
      categoryId: this.product.categoryId,
      categoryName: 'Loading...'
    }];

    // 3️⃣ Load full category list (API call)
    this.loadCategories();
  }


  loadCategories(): void {
    this.categoriesService.getAllCategories().subscribe({
      next: (res) => {
        if (res && res.respCode === 'Success' && Array.isArray(res.data)) {
          this.categories = res.data;
        } else {
          alert('Failed to load categories');
        }
      },
      error: () => {
        alert('Category API error');
      }
    });
  }

  
  onSubmit(form: any) {
    if (form.invalid) return;

    const payload = {
      product_id: this.product.productId,
      product_name: this.product.productName,
      category_id: this.product.categoryId,
      price: this.product.price,
      image_url: this.product.imageUrl
    };

    this.productService.updateProduct(payload).subscribe(res => {
      if (res && res.respCode === 'SUCCESS') {
        alert('Product updated successfully');
        this.productService.clearSelectedProduct();
        this.router.navigate(['/admin/products-list']);
      }
    });
  }

  cancel() {
    this.productService.clearSelectedProduct();
    this.router.navigate(['/admin/products-list']);
  }
}

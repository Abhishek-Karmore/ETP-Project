import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { CategoriesService } from 'src/app/services/categories/categories.service';
import { ProductService } from 'src/app/services/product/product.service';

@Component({
  selector: 'app-add-products',
  templateUrl: './add-products.component.html',
  styleUrls: ['./add-products.component.css']
})
export class AddProductsComponent implements OnInit {

  productForm!: FormGroup;
  submitted = false;

  // categories from DB
  categories: any[] = [];

  constructor(
    private fb: FormBuilder,
    private productService: ProductService,
    private categoriesService: CategoriesService,
    private router: Router
  ) { }

  ngOnInit(): void {

    // INIT FORM
    this.productForm = this.fb.group({
      product_name: ['', Validators.required],
      category_id: [null, Validators.required],
      price: ['', [Validators.required, Validators.min(1)]],
      image_url: ['', Validators.required]
    });

    // LOAD CATEGORIES
    this.loadCategories();
  }

  // LOAD CATEGORIES FROM SERVICE
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

  // FORM CONTROLS GETTER
  get f() {
    return this.productForm.controls;
  }

  // SUBMIT FORM
  onSubmit(): void {
    this.submitted = true;

    if (this.productForm.invalid) {
      return;
    }
    console.log(this.productForm.value);

    this.productService.addProduct(this.productForm.value).subscribe({
      next: (res) => {
        if (res && res.respCode === 'Success') {
          alert('Product added successfully');
          this.router.navigate(['/admin/products-list']);
        } else {
          alert('Failed to add product');
        }
      },
      error: () => {
        alert('Server error');
      }
    });
  }

}

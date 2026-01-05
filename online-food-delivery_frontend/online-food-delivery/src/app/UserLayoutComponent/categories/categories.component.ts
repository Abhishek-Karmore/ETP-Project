import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { CategoriesService } from 'src/app/services/categories/categories.service';

@Component({
  selector: 'app-categories',
  templateUrl: './categories.component.html',
  styleUrls: ['./categories.component.css']
})
export class CategoriesComponent {

   categories: any[] = []; // dynamic data

  constructor(
    private router: Router,
    private categoriesService: CategoriesService
  ) {}

  ngOnInit(): void {
    this.loadCategories();
  }

  loadCategories() {
    this.categoriesService.getAllCategories().subscribe({
      next: (res) => {
        this.categories = res.data; //  IMPORTANT
      },
      error: (err) => {
        console.error('Failed to load categories - categories.component.ts:29', err);
      }
    });
  }

  goToProducts(categoryId: number) {
    this.router.navigate(['/products', categoryId]);
  }
}



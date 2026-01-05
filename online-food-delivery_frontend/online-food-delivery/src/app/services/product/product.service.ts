import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../../models/product.model';
import { ProductRequest } from '../../models/product-request.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
 
  // USER API
  private apiGetByCatId = 'http://localhost:8080/getproductbycatid';

  // ADMIN APIs
  private apiGetAll = 'http://localhost:8080/getallproducts';
  private apiSave = 'http://localhost:8080/saveproduct';
  private apiUpdate = 'http://localhost:8080/updateproduct';
  private apiDelete = 'http://localhost:8080/deleteproduct';


  // ================= SHARED STATE (EDIT PRODUCT) =================

private selectedProduct: any = null;

setSelectedProduct(product: any) {
  this.selectedProduct = product;
}

getSelectedProduct() {
  return this.selectedProduct;
}

clearSelectedProduct() {
  this.selectedProduct = null;
}


  constructor(private http: HttpClient) {}

  // ================= USER =================

  getProductsByCategory(categoryId: number): Observable<Product[]> {

    const requestBody: ProductRequest = {
      actionId: 'GET_PRODUCTS_BY_CATID',
      formData: {
        categoryId: categoryId
      }
    };

    return this.http.post<Product[]>(this.apiGetByCatId, requestBody);
  }

  // ================= ADMIN =================

  // 📦 GET ALL PRODUCTS (ADMIN)
  getAllProducts(): Observable<any> {
    const requestBody = {
      actionId: 'GET_ALL_PRODUCTS',
      formData: {}
    };

    return this.http.post<any>(this.apiGetAll, requestBody);
  }

  // ➕ ADD PRODUCT
  addProduct(product: any): Observable<any> {
    const requestBody = {
      actionId: 'SAVE_ALL_PRODUCTS',
      formData: {
        productName: product.product_name,
        categoryId: product.category_id,
        price: product.price,
        imageUrl: product.image_url
      }
    };

    return this.http.post<any>(this.apiSave, requestBody);
  }

  // ✏️ UPDATE PRODUCT
  updateProduct(product: any): Observable<any> {
    const requestBody = {
      actionId: 'UPDATE_PRODUCT',
      formData: {
        productId: product.product_id,
        productName: product.product_name,
        categoryId: product.category_id,
        price: product.price,
        imageUrl: product.image_url
      }
    };

    return this.http.post<any>(this.apiUpdate, requestBody);
  }

  // ❌ DELETE PRODUCT
  deleteProduct(productId: number): Observable<any> {
    const requestBody = {
      actionId: 'DELETE_PRODUCT',
      formData: {
        productId: productId
      }
    };

    return this.http.post<any>(this.apiDelete, requestBody);
  }
}

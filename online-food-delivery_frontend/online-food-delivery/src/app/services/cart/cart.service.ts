import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CartItem } from 'src/app/models/cart-item.model';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  private cartItems: CartItem[] = [];
  private cartSubject = new BehaviorSubject<CartItem[]>([]);

  cart$ = this.cartSubject.asObservable();

  constructor(private http: HttpClient) { }

  addToCart(product: any) {

    const existing = this.cartItems.find(
      item => item.productId === product.productId
    );

    // 🔒 If already in cart → DO NOTHING
    if (existing) {
      return;
    }

    // ✅ Add only once
    this.cartItems.push({
      productId: product.productId,
      productName: product.productName,
      price: product.price,
      imageUrl: product.imageUrl,
      quantity: 1,
      total: product.price
    });

    this.cartSubject.next(this.cartItems);
  }


  // Increase quantity
  increaseQty(item: CartItem) {
    item.quantity++;
    item.total = item.quantity * item.price;
    this.cartSubject.next(this.cartItems);
  }

  // Decrease quantity
  decreaseQty(item: CartItem) {
    if (item.quantity > 1) {
      item.quantity--;
      item.total = item.quantity * item.price;
    }
    this.cartSubject.next(this.cartItems);
  }

  // Remove item
  removeItem(item: CartItem) {
    this.cartItems = this.cartItems.filter(
      i => i.productId !== item.productId
    );
    this.cartSubject.next(this.cartItems);
  }

  clearCart() {
    this.cartItems = [];           //  clear actual data
    this.cartSubject.next([]);     //  notify subscribers
  }


  // Get grand total
  getGrandTotal(): number {
    return this.cartItems.reduce((sum, item) => sum + item.total, 0);
  }


  // ========================
  // GET CART
  // ========================
  getCartItems(): CartItem[] {
    return this.cartItems;
  }


  // ========================
  //  SAVE CART TO DB (AFTER PAYMENT)
  // ========================
  saveCartToDb(cartItems: CartItem[]) {

    const userId = Number(localStorage.getItem('userId'));

    if (!userId) {
      alert('User not logged in');
      return;
    }

    cartItems.forEach(item => {

      const payload = {
        actionId: 'SAVE_ORDER',
        formData: {
          userId: userId,
          productId: item.productId,
          quantity: item.quantity,
          totalAmount: item.total
        }
      };

      this.http.post(
        'http://localhost:8080/saveorder',
        payload
      ).subscribe({
        next: () => {
          console.log('Order saved for product: - cart.service.ts:116', item.productId);
        },
        error: () => {
          alert('Failed to save order');
        }
      });

    });
  }

}

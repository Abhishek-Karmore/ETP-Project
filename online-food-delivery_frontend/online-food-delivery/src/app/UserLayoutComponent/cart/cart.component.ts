import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartItem } from 'src/app/models/cart-item.model';
import { CartService } from 'src/app/services/cart/cart.service';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  cartItems: CartItem[] = [];
  grandTotal = 0;

  constructor(
    private cartService: CartService,
    private router: Router

  ) { }

  ngOnInit() {
    this.cartService.cart$.subscribe(items => {
      this.cartItems = items;
      this.grandTotal = this.cartService.getGrandTotal();
    });
  }

  increase(item: CartItem) {
    this.cartService.increaseQty(item);
  }

  decrease(item: CartItem) {
    this.cartService.decreaseQty(item);
  }

  remove(item: CartItem) {
    this.cartService.removeItem(item);
  }

 goToPayment() {
  const isLoggedIn = localStorage.getItem('isLoggedIn');

  if (isLoggedIn === 'true') {
    //  User is logged in → go to payment
    this.router.navigate(['/payment']);
  } else {
    //  Not logged in → redirect to login
    alert('Please login to proceed with payment');
    this.router.navigate(['/login']);
  }
}


}

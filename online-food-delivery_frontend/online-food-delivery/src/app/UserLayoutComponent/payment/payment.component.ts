import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { CartService } from 'src/app/services/cart/cart.service';

@Component({
  selector: 'app-payment',
  templateUrl: './payment.component.html',
  styleUrls: ['./payment.component.css']
})
export class PaymentComponent implements OnInit {

  ngOnInit() {
  }

  paymentMethod = '';
  paymentSuccess = false;

  constructor(
    private cartService: CartService,
    private router: Router
  ) {}

  // payNow() {
  //   // simulate payment success
  //   this.paymentSuccess = true;

  //   // clear cart after payment
  //   this.cartService.clearCart();

  //   // redirect after 3 sec (optional)
  //   setTimeout(() => {
  //     this.router.navigate(['/']);
  //   }, 3000);
  // }
  
payNow() {

  this.paymentSuccess = true;

  const cartItems = this.cartService.getCartItems();

  this.cartService.saveCartToDb(cartItems);

  this.cartService.clearCart();

  setTimeout(() => {
    this.router.navigate(['/']);
  }, 3000);
}

}

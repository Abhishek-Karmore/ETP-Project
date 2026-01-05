import { Component } from '@angular/core';
import { AuthService } from 'src/app/services/Auth/auth.service';
import { CartService } from 'src/app/services/cart/cart.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent {
 isLoggedIn = false;
  userName = '';
  cartCount = 0;

  constructor(
    private cartService: CartService,
    private authService: AuthService
  ) {}

  ngOnInit(): void {

    this.cartService.cart$.subscribe(items => {
      this.cartCount = items.reduce((t, i) => t + i.quantity, 0);
    });

    this.authService.isLoggedIn$.subscribe(status => {
      this.isLoggedIn = status;
    });

    this.authService.userName$.subscribe(name => {
      this.userName = name;
    });
  }

  logout() {
    this.authService.logout();
  }
}

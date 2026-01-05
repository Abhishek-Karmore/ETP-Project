import { Component, OnInit } from '@angular/core';
import { OrderService } from 'src/app/services/order/order.service';

@Component({
  selector: 'app-order',
  templateUrl: './order.component.html',
  styleUrls: ['./order.component.css']
})
export class OrderComponent implements OnInit {
  orders: any[] = [];
  loading = true;

  constructor(private orderService: OrderService) { }

  ngOnInit(): void {
    this.fetchOrders();
  }

  fetchOrders() {
    this.orderService.getOrdersByUserId().subscribe({
      next: (res) => {
        if (res.respCode === 'Success') {
          this.orders = res.data;
        }
        this.loading = false;
      },
      error: () => {
        alert('Failed to load orders');
        this.loading = false;
      }
    });
  }
}

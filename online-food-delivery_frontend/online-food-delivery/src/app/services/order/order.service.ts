import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class OrderService {

 constructor(private http: HttpClient) {}

  getOrdersByUserId() {

    const userId = Number(localStorage.getItem('userId'));

    const payload = {
      actionId: 'GET_ORDER_BY_USERID',
      formData: {
        userId: userId
      }
    };

    return this.http.post<any>(
      'http://localhost:8080/getorderbyuserid',
      payload
    );
  }
}

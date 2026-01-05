import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CategoriesService {

 private apiUrl = 'http://localhost:8080/getallcategories';

  constructor(private http: HttpClient) {}

  getAllCategories(): Observable<any> {
    const payload = {
      actionId: 'GET_ALL_CATEGORIES'
    };

    return this.http.post<any>(this.apiUrl, payload);
  }
}

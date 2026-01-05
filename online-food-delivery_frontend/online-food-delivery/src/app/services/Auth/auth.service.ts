import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private API_LOGIN = 'http://localhost:8080/getuserdetails';
  private API_REGISTER = 'http://localhost:8080/saveuserdetails';

  private loginSubject = new BehaviorSubject<boolean>(
    localStorage.getItem('isLoggedIn') === 'true'
  );

  private userNameSubject = new BehaviorSubject<string>(
    localStorage.getItem('userName') || ''
  );

  isLoggedIn$ = this.loginSubject.asObservable();
  userName$ = this.userNameSubject.asObservable();

  constructor(private http: HttpClient, private router: Router) { }


  login(email: string, password: string) {
    const payload = {
      actionId: 'GET_USERDETAILS',
      formData: {
        userName: '',
        email: '',
        password: ''
      }
    };

    this.http.post<any>(this.API_LOGIN, payload).subscribe(res => {

      // ✅ STEP 1: Check response
      if (res && res.respCode === 'Success' && Array.isArray(res.data)) {

        // ✅ STEP 2: Find matching user
        const matchedUser = res.data.find((u: any) =>
          u.email === email && u.password === password
        );

        // ✅ STEP 3: If user found
        if (matchedUser) {

          localStorage.setItem('isLoggedIn', 'true');
          localStorage.setItem('userId', matchedUser.userId);  
          localStorage.setItem('userName', matchedUser.userName);
          localStorage.setItem('role', matchedUser.role);

          this.loginSubject.next(true);
          this.userNameSubject.next(matchedUser.userName);

          // ✅ STEP 4: Role-based redirect
          if (matchedUser.role === 'Admin') {
            this.router.navigate(['/admin/dashboard']);
          } else {
            this.router.navigate(['']);
          }

        } else {
          alert('Invalid email or password');
        }

      } else {
        alert('Unable to login. Please try again.');
      }
    },
      error => {
        alert('Server error. Please try later.');
      });
  }


  // 📝 REGISTER (USER ONLY)
  register(userName: string, email: string, password: string) {

    const payload = {
      actionId: 'SAVE_USERDETAILS',
      formData: {
        userName: userName,
        email: email,
        password: password
      }
    };

    this.http.post<any>(this.API_REGISTER, payload).subscribe(res => {

      if (res && res.respCode === 'Success') {
        alert('Registration successful. Please login.');
        this.router.navigate(['/login']);
      } else {
        alert('Registration failed');
      }
    });
  }

  logout() {
    localStorage.clear();
    this.loginSubject.next(false);
    this.userNameSubject.next('');
    this.router.navigate(['/login']);
  }
}

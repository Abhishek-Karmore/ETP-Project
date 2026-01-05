import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/Auth/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  userName = '';
  email = '';
  password = '';
  confirmPassword = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  register() {

    // 🔒 Basic validation
    if (!this.userName || !this.email || !this.password) {
      return;
    }

    if (this.password !== this.confirmPassword) {
      alert('Password and Confirm Password do not match');
      return;
    }

    // 🔥 Call AuthService
    this.authService.register(this.userName, this.email, this.password);
  }

  goToLogin() {
    this.router.navigate(['/login']);
  }
}

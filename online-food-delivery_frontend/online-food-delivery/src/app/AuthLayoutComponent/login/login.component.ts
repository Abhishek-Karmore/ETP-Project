import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/services/Auth/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(
    private router:Router,
    private authService:AuthService
  ) {}

  ngOnInit() {
  }
  email = '';
  password = '';


  login() {
    this.authService.login(this.email, this.password);
  }
  goToRegister()
  {
    this.router.navigate(['/register']);
  }
}

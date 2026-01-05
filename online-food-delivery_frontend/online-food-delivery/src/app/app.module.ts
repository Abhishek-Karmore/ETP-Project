import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './UserLayoutComponent/home/home.component';
import { HeaderComponent } from './UserLayoutComponent/header/header.component';
import { FooterComponent } from './UserLayoutComponent/footer/footer.component';
import { CategoriesComponent } from './UserLayoutComponent/categories/categories.component';
import { ProductsComponent } from './UserLayoutComponent/products/products.component';
import { CartComponent } from './UserLayoutComponent/cart/cart.component';
import { PaymentComponent } from './UserLayoutComponent/payment/payment.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { LoginComponent } from './AuthLayoutComponent/login/login.component';
import { DashboardComponent } from './AdminLayoutComponent/admindashboard/dashboard.component';
import { RegisterComponent } from './AuthLayoutComponent/register/register.component';
import { UserlayoutComponent } from './UserLayoutComponent/userlayout/userlayout.component';
import { AdminLayoutComponent } from './AdminLayoutComponent/admin-layout/admin-layout.component';
import { AddProductsComponent } from './AdminLayoutComponent/add-products/add-products.component';
import { AdminproductsListComponent } from './AdminLayoutComponent/adminproducts-list/adminproducts-list.component';
import { EditProductsComponent } from './AdminLayoutComponent/edit-products/edit-products.component';
import { OrderComponent } from './UserLayoutComponent/order/order.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    CategoriesComponent,
    ProductsComponent,
    CartComponent,
    PaymentComponent,
    LoginComponent,
    DashboardComponent,
    RegisterComponent,
    UserlayoutComponent,
    AdminLayoutComponent,
    AddProductsComponent,
    AdminproductsListComponent,
    EditProductsComponent,
    OrderComponent,
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule, 
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

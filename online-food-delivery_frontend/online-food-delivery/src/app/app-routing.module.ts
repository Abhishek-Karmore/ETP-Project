import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './UserLayoutComponent/home/home.component';
import { CategoriesComponent } from './UserLayoutComponent/categories/categories.component';
import { ProductsComponent } from './UserLayoutComponent/products/products.component';
import { CartComponent } from './UserLayoutComponent/cart/cart.component';
import { PaymentComponent } from './UserLayoutComponent/payment/payment.component';
import { LoginComponent } from './AuthLayoutComponent/login/login.component';
import { DashboardComponent } from './AdminLayoutComponent/admindashboard/dashboard.component';
import { RegisterComponent } from './AuthLayoutComponent/register/register.component';
import { UserlayoutComponent } from './UserLayoutComponent/userlayout/userlayout.component';
import { AdminLayoutComponent } from './AdminLayoutComponent/admin-layout/admin-layout.component';
import { AddProductsComponent } from './AdminLayoutComponent/add-products/add-products.component';
import { AdminproductsListComponent } from './AdminLayoutComponent/adminproducts-list/adminproducts-list.component';
import { EditProductsComponent } from './AdminLayoutComponent/edit-products/edit-products.component';
import { OrderComponent } from './UserLayoutComponent/order/order.component';

const routes: Routes = [

  // AUTH (NO HEADER / FOOTER)
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

  // USER LAYOUT
  {
    path: '',
    component: UserlayoutComponent,
    children: [
      { path: '', component: HomeComponent },
      { path: 'cart', component: CartComponent },
      { path: 'categories', component: CategoriesComponent },
      { path: 'products/:categoryId', component: ProductsComponent },
      { path: 'cart', component: CartComponent },
      { path: 'payment', component: PaymentComponent },
      { path: 'order', component: OrderComponent },
    ]
  },
  // ADMIN LAYOUT
  {
    path: 'admin',
    component: AdminLayoutComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent },
      { path: 'products-list', component: AdminproductsListComponent },
      { path: 'addproducts', component: AddProductsComponent },
      { path: 'edit-product', component: EditProductsComponent }
    ]
  },

  { path: '**', redirectTo: '' }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

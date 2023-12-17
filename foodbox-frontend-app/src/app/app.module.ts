import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CommonModule } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CuisineComponent } from './cuisine/cuisine.component';
import { ProductComponent } from './product/product.component';
import { TagComponent } from './tag/tag.component';
import { UserComponent } from './user/user.component';
import { UserRolesComponent } from './user-roles/user-roles.component';

@NgModule({
  declarations: [
    AppComponent,
    CuisineComponent,
    ProductComponent,
    TagComponent,
    UserComponent,
    UserRolesComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    CommonModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

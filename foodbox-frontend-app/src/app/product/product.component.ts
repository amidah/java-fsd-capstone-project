import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from 'src/app/product-service.service'
import { Product } from '../product';

@Component({
  selector: 'app-product',
  templateUrl: './product.component.html',
  styleUrls: ['./product.component.css']
})
export class ProductComponent implements OnInit {

products : Product[] = [];

  constructor(public productService : ProductServiceService) { }

  ngOnInit(): void {

    this.productService.getAllProducts().subscribe((data : Product[])=>
    {
      console.log(data);
      this.products = data;
    })

  }

}

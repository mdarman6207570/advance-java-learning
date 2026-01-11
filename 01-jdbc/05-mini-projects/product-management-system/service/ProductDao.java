package com.product.service;

import com.product.bean.Product;

public interface ProductDao 
{
	abstract int addProduct(Product p);
	abstract int updateProduct(Product p);
	abstract int deleteProduct(int id);
	abstract int getProductById(int id);
	abstract int getAllProducts();

}
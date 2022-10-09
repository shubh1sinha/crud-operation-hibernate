package com.entity.java;

import java.util.List;
/**
 * 
 * @author shusinha5
 *
 */
public class Main {
	public static void main(String[] args) throws Exception{

//Product
//create table product(id int,name varchar(20), price long(20));
	
	ProductDAO dao = new ProductDaoImpl();
	
	System.out.println("---Check By Id---");
	System.out.println(dao.findProduct(2));
	
	System.out.println("---Add new Customer---");
	System.out.println(dao.addProduct(new Product(10, "Iphone",1000)));
	
	System.out.println("--- Customer list---");
	List<Product> prodlist = dao.listAllProducts();
	for (Product p : prodlist) {
		System.out.println(p);
	}
	}

}

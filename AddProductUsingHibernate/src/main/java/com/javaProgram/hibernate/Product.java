package com.javaProgram.hibernate;

public class Product {
	private String ProductId;
	private String ProductName;
	private String ProductPrice;

	public Product(String id, String name, String price) {
		super();
		this.ProductId = id;
		this.ProductName = name;
		this.ProductPrice = price;
		
	}

	public String getid() {
		return ProductId;
	}

	public void setid(String id) {
		this.ProductId = id;
	}

	public String getname() {
		return ProductName;
	}

	public void setname(String name) {
		this.ProductName = name;
	}

	public String getprice() {
		return ProductPrice;
	}

	public void setprice(String price) {
		this.ProductPrice = price;
	}

	


}

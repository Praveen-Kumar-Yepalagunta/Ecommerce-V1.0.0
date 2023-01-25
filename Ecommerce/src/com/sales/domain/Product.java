package com.sales.domain;

import java.io.Serializable;

public class Product implements Serializable{

	int id;
	String productName;
	double price;
	int qty;
	String mfName;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String productName, double price, int qty, String mfName) {
		super();
		this.id = id;
		this.productName = productName;
		this.price = price;
		this.qty = qty;
		this.mfName = mfName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public String getMfName() {
		return mfName;
	}
	public void setMfName(String mfName) {
		this.mfName = mfName;
	}
	
	public double getStockValue()
	{
		return price*qty;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return id+"\t"+productName+"\t"+mfName+"\t"+price+"\t"+qty+"\t"+getStockValue();
	}
}

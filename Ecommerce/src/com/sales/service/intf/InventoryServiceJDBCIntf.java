package com.sales.service.intf;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;

import com.sales.domain.Product;

public interface InventoryServiceJDBCIntf {
	public Product addInventory(Connection con,Product prod);
//	public void showAProduct(Product prod);
	public void showAllProducts(Connection con);
	public Product searchForProductId(Connection con,int prodId);
//	public Product updateProductUsingId(Connection con,int prodId,int qty,double price);
//	public boolean deleteProduct(Connection con,Product prod);
	
}

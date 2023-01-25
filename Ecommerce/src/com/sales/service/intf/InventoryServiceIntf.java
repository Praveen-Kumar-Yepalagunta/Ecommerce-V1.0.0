package com.sales.service.intf;

import java.io.IOException;
import java.util.List;

import com.sales.domain.Product;

public interface InventoryServiceIntf {
	public Product addInventory(List<Product> list,Product prod);
	public void showAProduct(Product prod);
	public void showAllProducts(List<Product> list);
	public Product searchForProductId(List<Product> list,int prodId);
	public Product updateProductUsingId(List<Product> list,int prodId,int qty,double price);
	public boolean deleteProduct(List<Product> list,Product prod);
	public void saveToFile(List<Product> list) throws IOException;
	public List<Product> loadDataFromFile() throws Exception;
	public void saveObjectsToFile(List<Product> list) throws Exception;
	public List<Product> readObjectsFromFile() throws Exception;

}

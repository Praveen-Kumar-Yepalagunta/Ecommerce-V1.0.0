 
package com.sales.app;

import java.io.IOException;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;



import com.sales.domain.Product;
import com.sales.helper.ReadFromConsole;
import com.sales.service.InventoryJDBCService;
import com.sales.service.InventoryService;
import com.sales.service.intf.InventoryServiceIntf;
import com.sales.service.intf.InventoryServiceJDBCIntf;

public class InventoryJDBCApp {

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		

		int choice = 0;
		int prodId;
		String prodName;
		double price;
		int qty;
		String mfName;

		InventoryServiceJDBCIntf inventoryService = new InventoryJDBCService();
		Product prod = null;
		Connection con=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/abdul", "root", "root");
		
		do {

			showMenu();
			choice = ReadFromConsole.readInt("Enter your choice [1-4]:");
			switch (choice) {
			case 1:
				prodId = ReadFromConsole.readInt("Product id:");
				prodName = ReadFromConsole.readString("Product Name:");
				mfName = ReadFromConsole.readString("Product Description:");
				price = ReadFromConsole.readDouble("Product Price:");
				qty = ReadFromConsole.readInt("Product Qty:");
				prod = new Product(prodId, prodName, price, qty, mfName);
				inventoryService.addInventory(con, prod);

				break;
			case 2:
		        prodId = ReadFromConsole.readInt("Product Id to search for:");
//				prod = inventoryService.searchForProductId(ivtApp.productList, prodId);
//				if (prod != null)
//					inventoryService.showAProduct(prod);
//				else
//					System.out.println("The given product id is not found in the inventory");
//					
				 
					prod = inventoryService.searchForProductId(con, prodId);		
				break;
			case 3:
				inventoryService.showAllProducts(con);
				break;
			case 4:
				System.out.println("You are Exit!");
				break;
			default:
				break;
			}

		} while (choice != 4);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	private static void showMenu() {
		// TODO Auto-generated method stub

		System.out.println("1.Add product to inventory");
		System.out.println("2.Search a product");
		System.out.println("3.Show all products");
//		System.out.println("4.Update product price/qty");
//		System.out.println("5.Delete a product using id");
//		System.out.println("6. Save Data to File");
//		System.out.println("7. Save as Objects to a file");
		System.out.println("4.Exit");

	}

}

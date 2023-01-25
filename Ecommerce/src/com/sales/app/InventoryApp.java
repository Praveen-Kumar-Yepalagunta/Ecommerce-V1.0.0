package com.sales.app;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.sales.domain.Product;
import com.sales.helper.ReadFromConsole;
import com.sales.service.InventoryService;
import com.sales.service.intf.InventoryServiceIntf;

public class InventoryApp {

	List<Product> productList = new ArrayList<Product>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		InventoryApp ivtApp = new InventoryApp();  // initializing ivtApp object

		int choice = 0; 
		int prodId;
		String prodName;
		double price;
		int qty;
		String mfName;

		InventoryServiceIntf inventoryService = new InventoryService(); // initializing inventoryService object
		Product prod = null;
		
		try {
			ivtApp.productList=inventoryService.readObjectsFromFile();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		do {

			showMenu();
//			choice = ReadFromConsole.readInt("Enter your choice [1-8]:");
			choice = ReadFromConsole.readInt("Enter your choice [1-4]:");
			switch (choice) {
			case 1:
				prodId = ReadFromConsole.readInt("Product id:");
				prodName = ReadFromConsole.readString("Product Name:");
				mfName = ReadFromConsole.readString("Product Description:");
				price = ReadFromConsole.readDouble("Product Price:");
				qty = ReadFromConsole.readInt("Product Qty:");
				prod = new Product(prodId, prodName, price, qty, mfName);
				inventoryService.addInventory(ivtApp.productList, prod);

				break;
			case 2:
				prodId = ReadFromConsole.readInt("Product Id to search for:");
				prod = inventoryService.searchForProductId(con, prodId);
//				if (prod != null)
//					inventoryService.showAProduct(prod);
//				else
					System.out.println("The givent product id is not found in the inventory");
				break;
			case 3:
				inventoryService.showAllProducts(ivtApp.productList);
				break;
			case 4:
				System.out.println("You are Exit!");
				break;
/*			case 4:
				prodId = ReadFromConsole.readInt("Product id:");
				prod = inventoryService.searchForProductId(ivtApp.productList, prodId);
				if (prod != null) {
					System.out.println("Before Udpate ");
					inventoryService.showAProduct(prod);
					price = ReadFromConsole.readDouble("New Product Price:" + "[" + prod.getPrice() + "]:");
					qty = ReadFromConsole.readInt("New Product Qty:" + "[" + prod.getQty() + "]:");
					prod = inventoryService.updateProductUsingId(ivtApp.productList, prodId, qty, price);
					System.out.println("After Update");
					inventoryService.showAProduct(prod);
				} else
					System.out.println("The product id :" + prodId + " Not found in the list");
				break;
			case 5:
				prodId = ReadFromConsole.readInt("Product id:");
				prod = inventoryService.searchForProductId(ivtApp.productList, prodId);
				if (prod != null) {
					System.out.println("Before Delete ");
					inventoryService.showAProduct(prod);
					boolean confirm = ReadFromConsole
							.readBoolean("Do you really want to delete this product [TRUE/FALSE]");
					if (confirm) {
						inventoryService.deleteProduct(ivtApp.productList, prod);
						System.out.println("Product Deleted Successfully from the list");
					}

				} else
					System.out.println("The product id :" + prodId + " Not found in the list");
				break;
			case 6:
				try {
					inventoryService.saveToFile(ivtApp.productList);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Saving Data Completed");
				break;
			case 7:
				try {
					inventoryService.saveObjectsToFile(ivtApp.productList);
					System.out.println("Objects Saved to a serialized file");
				} catch (Exception e) {
					// TODO: handle exception
				}
				break; */
			default:
				break;
			}
		

		} while (choice != 4);

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

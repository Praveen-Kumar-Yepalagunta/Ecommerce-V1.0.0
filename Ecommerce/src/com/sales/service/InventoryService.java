package com.sales.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.sales.domain.Product;
import com.sales.service.intf.InventoryServiceIntf;

public class InventoryService implements InventoryServiceIntf{
	
	
	public Product addInventory(List<Product> list,Product prod)
	{
		list.add(prod);
		return prod;
	}
	
	public void showAProduct(Product prod)
	{
		System.out.println("Product Id:"+prod.getId());
		System.out.println("Product Name:"+prod.getProductName());
		System.out.println("Manufacture's Name:"+prod.getMfName());
		System.out.println("Product Price :"+prod.getPrice());
		System.out.println("In Stock :"+prod.getQty());
		System.out.println("Stock value of the product:"+prod.getStockValue());
	}
	
	public void showAllProducts(List<Product> list)
	{
		if(list.isEmpty())
			System.out.println("There are no products in the store");
		else if(list.size()>0)
		{
			Iterator<Product> iterator=list.iterator();
			while(iterator.hasNext())
			{
				System.out.println(iterator.next());
			}
		}
		
	}
	
	public Product searchForProductId(List<Product> list,int prodId) {
		Product prod=null;
		
		if(list.size()>0)
		{
			Iterator<Product> iterator=list.iterator();
			while(iterator.hasNext())
			{
				prod=iterator.next();
				if(prod.getId()==prodId)
					return prod;
			}
		}
		return null;
	}
	
	public Product updateProductUsingId(List<Product> list,int prodId,int qty,double price)
	{
		Product findProd=searchForProductId(list, prodId);
		if(findProd!=null)
		{
			findProd.setPrice(price);
			findProd.setQty(qty);
			return findProd;
		}
		return null;
		
		
	}
	
	public boolean deleteProduct(List<Product> list,Product prod)
	{
		return list.remove(prod);
		
	}
	
	public void saveToFile(List<Product> list) throws IOException
	{
		FileWriter fw=null;
		PrintWriter pw=null;
		if(list.size()>0)
		{
		try {
			fw=new FileWriter("InventoryData.txt");
			pw=new PrintWriter(fw);
			for(Product p:list)
			{   System.out.print(".");
				pw.write(p.getId()+","+p.getProductName()+","+p.getMfName()+","+p.getPrice()+","+p.getQty()+"\n");
				pw.flush();
			}
			pw.close();
			fw.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		finally {
			if(fw!=null)
				fw.close();
			if(pw!=null)
				pw.close();
				
			
		}
		
	
		
		}
	}
	
	public List<Product> loadDataFromFile() throws Exception
	{
		FileReader fr=null;
		BufferedReader br=null;
		List<Product> products=new ArrayList<>();
				
		try {
			fr=new FileReader("InventoryData.txt");
			br=new BufferedReader(fr);
			String data=br.readLine();
			StringTokenizer tokens=null;
			while(data!=null)
			{
				tokens=new StringTokenizer(data,",");
				if(tokens.hasMoreElements())
				   {Product p= new Product();
				      p.setId(Integer.parseInt(tokens.nextToken()));
				      p.setProductName(tokens.nextToken());
				      p.setMfName(tokens.nextToken());
					  p.setPrice(Double.parseDouble(tokens.nextToken()));
				      p.setQty(Integer.parseInt(tokens.nextToken()));
				      products.add(p);
				   }
				data=br.readLine();
			}
			br.close();
			fr.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		
		return products;
	}
	
	public void saveObjectsToFile(List<Product> list) throws Exception
	{
		FileOutputStream fos=null;
		ObjectOutputStream oos;
		if(list.size()>0)
		{
		try {
			fos=new FileOutputStream("InventoryData.ser");
			
			oos=new ObjectOutputStream(fos);
			oos.writeObject(list);
	/*		oos.writeObject(new Integer(list.size()));
			for(Product p:list)
			{
				oos.writeObject(p);
			}
		*/	fos.close();
			oos.close();
			
					
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		}
	}
	
	public List<Product> readObjectsFromFile() throws Exception
	{
		List<Product> products=new ArrayList<>();
		
		FileInputStream fis=null;
		ObjectInputStream ois=null;
		try {
			fis=new FileInputStream("InventoryData.ser");
			ois=new ObjectInputStream(fis);
			products=(List)ois.readObject();
		/*	int recCount=(Integer)ois.readObject();
			for(int i=1;i<=recCount;i++)
			{
				Product p=(Product)ois.readObject();
				products.add(p);
			}
		*/	fis.close();
		    ois.close();
		} catch (Exception e) {
			// TODO: handle exception
			throw e;
		}
		return products;
	}
	
}
